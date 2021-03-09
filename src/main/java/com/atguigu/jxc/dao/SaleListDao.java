package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleListDao {

    Integer saveSale(SaleList saleList);

    Integer saveSaleListGoods(@Param("list") List<SaleListGoods> saleListGoods,@Param("saleListId") Integer saleListId);
}
