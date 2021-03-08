package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * @description
 */
public interface CustomerService {

    Map<String,Object> list(Integer page, Integer rows, String customerName);

    ServiceVO save(Customer customer);

    ServiceVO delete(String ids);

}
