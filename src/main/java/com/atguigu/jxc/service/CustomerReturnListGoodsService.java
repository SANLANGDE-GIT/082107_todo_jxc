package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;

import java.util.Map;

public interface CustomerReturnListGoodsService {


    Map<String, Object> queryReturnList(String returnNumber, Integer customerId, Integer state, String sTime,String eTime);

    Map<String, Object> goodsList(Integer customerReturnListId);

    ServiceVO deleteReturnListBycustomerReturnListId(Integer customerReturnListId);
}
