package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 供应商统计Controller控制器
 */
@RestController
@RequestMapping("/purchaseListGoods")
public class PurchaseListGoodsController {

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    /**
     * 支付结算（修改进货单付款状态）
     *
     * @param  purchaseListId 进货单id，主键
     * @return
     */

    @PostMapping("/updateState")
    @RequiresPermissions(value = "供应商统计")
    public ServiceVO   updateState(Integer purchaseListId){

       return purchaseListGoodsService.updateState(purchaseListId);


    }


}
