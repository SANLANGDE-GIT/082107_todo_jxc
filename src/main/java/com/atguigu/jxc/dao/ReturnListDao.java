package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.ReturnListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReturnListDao {

    List<ReturnListGoods> list(@Param("returnNumber") String returnNumber,
                               @Param("supplierId") Integer supplierId,
                               @Param("state") Integer state,
                               @Param("t1") String sTime,
                               @Param("t2") String eTime);
}
