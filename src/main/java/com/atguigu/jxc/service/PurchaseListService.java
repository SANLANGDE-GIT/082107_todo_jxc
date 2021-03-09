package com.atguigu.jxc.service;

import java.util.Map;

/**
 * @title: PurchaseListGoodsService
 * @Author pluto
 * @Date: 2021/3/9 15:43
 * @Version 1.0
 */
public interface PurchaseListService {
    Map<String, Object> getPurchaseList(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime);
}
