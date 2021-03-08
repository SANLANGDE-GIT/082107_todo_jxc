package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.service.DamageListGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description 商品报损商品Controller层
 */
@RestController
@RequestMapping("/damageListGoods")
public class DamageListGoodsController {

    @Autowired
    private DamageListGoodsService damageListGoodsService;

    /**
     * 保存商品报损单信息
     * @param damageList 商品报损单信息实体
     * @param damageListGoodsStr 商品报损商品信息JSON字符串
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "商品报损")
    public ServiceVO save(DamageList damageList, String damageListGoodsStr) {
        return damageListGoodsService.save(damageList, damageListGoodsStr);
    }

    /**
     * 查询商品报损单
     * @param sTime 开始时间
     * @param eTime 结束时间
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "报损报溢查询")
    public Map<String,Object> list(String sTime, String eTime) {
        return damageListGoodsService.list(sTime, eTime);
    }

    /**
     * 查询商品报损单商品信息
     * @param damageListId 商品报损单ID
     * @return
     */
    @RequestMapping("/goodsList")
    @RequiresPermissions(value = "报损报溢查询")
    public Map<String,Object> goodsList(Integer damageListId) {
        return damageListGoodsService.goodsList(damageListId);
    }
}
