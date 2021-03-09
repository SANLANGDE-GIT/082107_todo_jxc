package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface SaleListGoodsDao {


    List<SaleList> getSaleListGoods(@Param("saleNumber") String saleNumber, @Param("customerId") Integer customerId, @Param("state") Integer state,@Param("sTime") String sTime, @Param("eTime") String eTime);


    List<SaleListGoods> getSaleListGoodsGoods(@Param("saleListId") Integer saleListId);
}
