package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description 客户Controller控制器
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    /**
     * 分页查询客户
     * @param page 当前页数
     * @param rows 每页显示的记录数
     * @param customerName 客户名
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "客户管理")// 有客户管理菜单权限的才给予调用
    public Map<String,Object> list(Integer page, Integer rows, String customerName) {
        return customerService.list(page, rows, customerName);
    }

    /**
     * 添加或修改客户
     * @param customer 客户实体
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "客户管理")
    public ServiceVO save(Customer customer) {
        return customerService.save(customer);
    }

    /**
     * 删除客户
     * @param ids 客户ids字符串，用逗号分隔
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "客户管理")
    public ServiceVO delete(String ids) {
        return customerService.delete(ids);
    }
}
