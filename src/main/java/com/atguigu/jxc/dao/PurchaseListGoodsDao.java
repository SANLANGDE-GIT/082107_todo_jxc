package com.atguigu.jxc.dao;

import org.apache.ibatis.annotations.Param;

public interface PurchaseListGoodsDao {


    Integer updateState(@Param("purchaseListId") Integer purchaseListId);

}
