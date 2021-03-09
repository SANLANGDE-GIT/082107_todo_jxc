package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.service.CustomerReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerReturnController {

    @Autowired
    private CustomerReturnService customerReturnService;

    @PostMapping("customerReturnListGoods/save")
    @ResponseBody
    public ServiceVO saveCustomerReturn(CustomerReturnList customerReturnList, String customerReturnListGoodsStr){
        return customerReturnService.saveCustomerReturn(customerReturnList,customerReturnListGoodsStr);
    }

}
