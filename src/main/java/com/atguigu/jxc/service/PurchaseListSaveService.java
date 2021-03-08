package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseList;

public interface PurchaseListSaveService {

    ServiceVO purchaseListSave(PurchaseList purchaseList, String purchaseListGoodsStr);
}
