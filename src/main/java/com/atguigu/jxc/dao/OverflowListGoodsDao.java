package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.OverflowList;
import com.atguigu.jxc.entity.OverflowListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 商品报溢
 */
public interface OverflowListGoodsDao {

    Integer saveOverflowList(OverflowList overflowList);

    Integer saveOverflowListGoods(OverflowListGoods overflowListGoods);

    List<OverflowList> getOverflowlist(@Param("sTime") String sTime, @Param("eTime") String eTime);

    List<OverflowListGoods> getOverflowListGoodsByOverflowListId(Integer overflowListId);
}
