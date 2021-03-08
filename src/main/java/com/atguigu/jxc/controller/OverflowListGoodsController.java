package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.OverflowList;
import com.atguigu.jxc.service.OverflowListGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description 商品报溢商品Controller层
 */
@RestController
@RequestMapping("/overflowListGoods")
public class OverflowListGoodsController {

    @Autowired
    private OverflowListGoodsService overflowListGoodsService;

    /**
     * 保存商品报溢单信息
     * @param overflowList 商品报溢单信息实体
     * @param overflowListGoodsStr 商品报溢商品信息JSON字符串
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "商品报溢")
    public ServiceVO save(OverflowList overflowList, String overflowListGoodsStr) {
        return overflowListGoodsService.save(overflowList, overflowListGoodsStr);
    }

    /**
     * 查询商品报溢单
     * @param sTime 开始时间
     * @param eTime 结束时间
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "报损报溢查询")
    public Map<String,Object> list(String sTime, String eTime) {
        return overflowListGoodsService.list(sTime, eTime);
    }

    /**
     * 查询商品报溢单商品信息
     * @param overflowListId 商品报溢单ID
     * @return
     */
    @RequestMapping("/goodsList")
    @RequiresPermissions(value = "报损报溢查询")
    public Map<String,Object> goodsList(Integer overflowListId) {
        return overflowListGoodsService.goodsList(overflowListId);
    }
}
