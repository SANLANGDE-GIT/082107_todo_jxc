package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.ReturnList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @title: PurchaseListGoodsDao
 * @Author pluto
 * @Date: 2021/3/9 15:47
 * @Version 1.0
 */
public interface PurchaseListDao {
    List<ReturnList> list(@Param("purchaseNumber") String purchaseNumber, @Param("supplierId") Integer supplierId, @Param("state") Integer state, @Param("sTime") String sTime, @Param("eTime") String eTime);
}
