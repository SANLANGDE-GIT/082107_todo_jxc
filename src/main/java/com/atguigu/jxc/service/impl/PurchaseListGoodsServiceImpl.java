package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListDao;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.PurchaseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: PurchaseListGoodsServiceImpl
 * @Author pluto
 * @Date: 2021/3/9 15:44
 * @Version 1.0
 */
@Service
class PurchaseListServiceImpl implements PurchaseListService {

    @Autowired
    PurchaseListDao purchaseListDao;

    @Override
    public Map<String, Object> getPurchaseList(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime) {
        Map<String,Object> map = new HashMap<>();
        List<ReturnList> returnListGoodsList =purchaseListDao.list(purchaseNumber,supplierId,state,sTime,eTime);
        map.put("rows",returnListGoodsList);
        return map;    }
}