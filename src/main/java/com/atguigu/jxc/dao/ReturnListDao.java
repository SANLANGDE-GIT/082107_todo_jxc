package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.vo.ReturnListGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReturnListDao {

    List<ReturnList> list(@Param("returnNumber") String returnNumber,
                          @Param("supplierId") Integer supplierId,
                          @Param("state") Integer state,
                          @Param("t1") String sTime,
                          @Param("t2") String eTime);

    List<ReturnListGoods> listGoods(@Param("returnListId") Integer returnListId);

    Integer deleteReturnListGoods(@Param("returnListId") Integer returnListId);

    Integer deleteReturnList(@Param("returnListId") Integer returnListId);

    List<ReturnListGoodsVo> findReturnListGoodsVos(@Param("start") String sTime,
                                                   @Param("end") String eTime,
                                                   @Param("goodsTypeId") Integer goodsTypeId,
                                                   @Param("codeOrName") String codeOrName);
}
