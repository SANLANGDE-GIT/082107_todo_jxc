package com.atguigu.jxc.service.impl;


import com.atguigu.jxc.dao.PurchaseListSaveDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.service.PurchaseListGoodsSaveService;
import com.atguigu.jxc.service.PurchaseListSaveService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class  PurchaseListSaveServiceImpl implements PurchaseListSaveService {

    @Autowired
    private PurchaseListSaveDao purchaseListSaveDao;

    @Autowired
    private PurchaseListGoodsSaveService purchaseListGoodsSaveService;


    @Transactional
    @Override
    public ServiceVO purchaseListSave(PurchaseList purchaseList, String purchaseListGoodsStr) {

        this.purchaseListSaveDao.purchaseListSave(purchaseList);
        Integer purchaseListId = purchaseList.getPurchaseListId();
        if (!StringUtils.isEmpty(purchaseListGoodsStr) || purchaseList ==null){
            this.purchaseListGoodsSaveService.purchaseListGoodsSave(purchaseListGoodsStr,purchaseListId);
        }

        return  new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }
}
