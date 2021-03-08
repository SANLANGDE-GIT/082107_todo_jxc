package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.DamageList;

import java.util.Map;

/**
 * @description
 */
public interface DamageListGoodsService {

    ServiceVO save(DamageList damageList, String damageListGoodsStr);

    Map<String,Object> list(String sTime, String eTime);

    Map<String,Object> goodsList(Integer damageListId);
}
