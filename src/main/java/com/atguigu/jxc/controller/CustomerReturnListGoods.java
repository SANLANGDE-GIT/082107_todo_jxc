package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customerReturnListGoods")
public class CustomerReturnListGoods {

    @Autowired
    private CustomerReturnListGoodsService goodsService;

    /**
     *  显示查询退货订单
     * @param returnNumber
     * @param customerId
     * @param state
     * @param sTime
     * @param eTime
     * @return
     */
    @PostMapping("/list")
    @RequiresPermissions(value = "退货单据查询")//
    public Map<String,Object> customerReturnListGoods(String returnNumber, Integer customerId, Integer state, String sTime, String eTime){
        System.out.println("-----------------------");
        Map<String, Object> stringObjectMap = goodsService.queryReturnList(returnNumber, customerId, state,  sTime, eTime);
        return stringObjectMap ;
    }


    /**
     * 退货单商品信息
     * @param customerReturnListId
     * @return
     */
    @PostMapping("/goodsList")
    public Map<String,Object> goodsList(Integer customerReturnListId){
        System.out.println(customerReturnListId);
        return goodsService.goodsList(customerReturnListId);
    }

    @PostMapping("/delete")
    public ServiceVO deleteReturnList(Integer customerReturnListId){
         Integer  i = goodsService.deleteReturnListBycustomerReturnListId(customerReturnListId);
         if(i>0){
             return new ServiceVO(0,"删除成功");
         }else {
             return new ServiceVO(0,"删除失败");
         }
    }
}
