package com.atguigu.jxc.service;

import java.util.Map;

public interface ReturnListService {
    Map<String, Object> list(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime);

    Map<String, Object> listGoods(Integer returnListId);

}
