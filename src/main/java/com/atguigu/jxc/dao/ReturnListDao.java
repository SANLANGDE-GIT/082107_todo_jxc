package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.ReturnList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReturnListDao {

    List<ReturnList> list(@Param("returnNumber") String returnNumber,
                          @Param("supplierId") Integer supplierId,
                          @Param("state") Integer state,
                          @Param("t1") String sTime,
                          @Param("t2") String eTime);

    List<PurchaseListGoods> listGoods(@Param("returnListId") Integer returnListId);
}
