package com.atguigu.jxc.interceptor;

import com.atguigu.jxc.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<User> THREAD_LOCAL=new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("这是拦截器前置方法");

        User userInfo = (User) request.getSession().getAttribute("currentUser");

        //状态字段导致线程安全问题，即使加锁也无法解决
        THREAD_LOCAL.set(userInfo);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("这是拦截器完成时方法");
        //在视图渲染完成之后执行，经常在完成方法中释放资源
        //这里必须清空threadLocal中的资源，因为使用的是tomcat线程池，线程无法结束
        THREAD_LOCAL.remove();
    }

    public static User getUserInfo(){
        return THREAD_LOCAL.get();
    }
}
