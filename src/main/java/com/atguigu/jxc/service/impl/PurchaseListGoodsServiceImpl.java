package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListGoodsDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {


    @Autowired
    private LogService logService;

    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;


    @Override
    public ServiceVO updateState(Integer purchaseListId) {

        logService.save(new Log(Log.SELECT_ACTION,"修改进货单付款状态"));
        purchaseListGoodsDao.updateState(purchaseListId);

        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);


    }
}
