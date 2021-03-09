package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.CustomerReturnList;

public interface CustomerReturnService {
    ServiceVO saveCustomerReturn(CustomerReturnList customerReturnList, String customerReturnListGoodsStr);
}
