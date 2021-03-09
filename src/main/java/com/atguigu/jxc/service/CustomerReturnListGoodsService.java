package com.atguigu.jxc.service;

import java.util.Map;

public interface CustomerReturnListGoodsService {


    Map<String, Object> queryReturnList(String returnNumber, Integer customerId, Integer state, String sTime,String eTime);

    Map<String, Object> goodsList(Integer customerReturnListId);

    Integer deleteReturnListBycustomerReturnListId(Integer customerReturnListId);
}
