package com.atguigu.jxc.controller;


import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.service.PurchaseListSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseListSaveController {


    @Autowired
    private PurchaseListSaveService purchaseListSaveService;

    @PostMapping("/purchaseListGoods/save")
    public ServiceVO purchaseListSave(PurchaseList purchaseList, String purchaseListGoodsStr){
        return this.purchaseListSaveService.purchaseListSave(purchaseList,purchaseListGoodsStr);
    }

}
