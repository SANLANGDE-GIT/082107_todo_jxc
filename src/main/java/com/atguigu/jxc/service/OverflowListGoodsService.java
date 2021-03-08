package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.OverflowList;

import java.util.Map;

/**
 * @description
 */
public interface OverflowListGoodsService {

    ServiceVO save(OverflowList overflowList, String overflowListGoodsStr);

    Map<String,Object> list(String sTime, String eTime);

    Map<String,Object> goodsList(Integer overflowListId);
}
