package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;

/**
 * @description
 */
public interface GoodsTypeService {

    ServiceVO delete(Integer goodsTypeId);

    ServiceVO save(String goodsTypeName,Integer pId);

    String loadGoodsType();
}
