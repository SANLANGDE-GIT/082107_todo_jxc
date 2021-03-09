package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description 销售单据Controller控制器
 */
@RestController
@RequestMapping("/saleListGoods")
public class SaleListGoodsController {

    @Autowired
    private SaleListGoodsService saleListGoodsService;


    /**
     * 销售单查询
     *
     * @param saleNumber 销售单号
     * @param customerId 客户id
     * @param state      付款状态
     * @param sTime
     * @param eTime
     * @return
     */

    @PostMapping("/list")
    @RequiresPermissions(value = "销售单据查询")
    public Map<String, Object> saleListGoodsList(
            @RequestParam(value = "saleNumber") String saleNumber
            , @RequestParam(value = "customerId") Integer customerId
            , @RequestParam(value = "state") Integer state
            , @RequestParam(value = "sTime") String sTime
            , @RequestParam(value = "eTime") String eTime) {

        return saleListGoodsService.saleListGoodsList(saleNumber, customerId, state, sTime, eTime);
    }

    @PostMapping("/goodsList")
    @RequiresPermissions(value = "销售单据查询")
    public Map<String, Object> saleListGoodsGoodsList(@RequestParam(value = "saleListId") Integer saleListId) {
        return saleListGoodsService.saleListGoodsGoodsList(saleListId);
    }


    /**
     * 删除销售单
     *
     * @param saleListId
     * @return
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = "销售单据查询")
    public ServiceVO deleteSaleListGoods(Integer saleListId) {

        return saleListGoodsService.deleteSaleListGoods(saleListId);

    }
}
