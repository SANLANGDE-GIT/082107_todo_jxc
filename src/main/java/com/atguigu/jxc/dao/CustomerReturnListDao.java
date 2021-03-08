package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.GoodsList;
import com.atguigu.jxc.entity.ReturnListGoods;

import java.util.List;

public interface CustomerReturnListDao {
    List<ReturnListGoods> queryReturn(Integer returnNumber, Integer customerId, Integer state, String sTime, String etime);

    List<GoodsList> getGoodz(Integer customerReturnListId);
}
