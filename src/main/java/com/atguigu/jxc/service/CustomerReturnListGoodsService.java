package com.atguigu.jxc.service;

import java.util.Map;

public interface CustomerReturnListGoodsService {


    Map<String, Object> queryReturnList(Integer returnNumber, Integer customerId, Integer state, Integer state1, String sTime,String etime);

    Map<String, Object> goodsList(Integer customerReturnListId);
}
