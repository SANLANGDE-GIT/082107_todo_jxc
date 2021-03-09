package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.entity.CustomerReturnListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerReturnDao {
    Integer saveCustomerReturn(CustomerReturnList customerReturnList);

    Integer saveCustomerReturnListGoods(@Param("list") List<CustomerReturnListGoods> customerReturnLists, @Param("customerReturnListId") Integer customerReturnListId);
}
