package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.GoodsType;

import java.util.List;

/**
 * @description 商品类别
 */
public interface GoodsTypeDao {

    List<GoodsType> getAllGoodsTypeByParentId(Integer pId);

    Integer saveGoodsType(GoodsType goodsType);

    GoodsType getGoodsTypeById(Integer goodsTypeId);

    Integer updateGoodsTypeState(GoodsType parentGoodsType);

    List<Goods> getGoodsByTypeId(Integer goodsTypeId);

    Integer delete(Integer goodsTypeId);
}
