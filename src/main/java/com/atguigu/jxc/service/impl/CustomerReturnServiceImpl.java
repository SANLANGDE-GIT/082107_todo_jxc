package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerReturnDao;
import com.atguigu.jxc.domain.ErrorCode;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.entity.CustomerReturnListGoods;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.interceptor.LoginInterceptor;
import com.atguigu.jxc.service.CustomerReturnService;
import com.atguigu.jxc.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerReturnServiceImpl implements CustomerReturnService {

    @Autowired
    private CustomerReturnDao customerReturnDao;

    @Override
    @Transactional
    public ServiceVO saveCustomerReturn(CustomerReturnList customerReturnList, String customerReturnListGoodsStr) {
        if(customerReturnList==null || StringUtil.isEmpty(customerReturnListGoodsStr))
        return new ServiceVO(ErrorCode.PARA_TYPE_ERROR_CODE,ErrorCode.PARA_TYPE_ERROR_MESS);

        customerReturnList.setUserId(LoginInterceptor.getUserInfo().getUserId());

        Gson gson = new Gson();
        List<CustomerReturnListGoods> customerReturnLists = gson.fromJson(customerReturnListGoodsStr,new TypeToken<List<CustomerReturnListGoods>>(){}.getType());
        if (this.customerReturnDao.saveCustomerReturn(customerReturnList)>0) {
            this.customerReturnDao.saveCustomerReturnListGoods(customerReturnLists,customerReturnList.getCustomerReturnListId());
            //TODO:加库存
            return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
        }

        return null;
    }
}
