package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.GoodsList;
import com.atguigu.jxc.entity.ReturnList;

import java.util.List;

public interface CustomerReturnListDao {
    List<ReturnList> queryReturn(String returnNumber, Integer customerId, Integer state, String sTime, String eTime);

    List<GoodsList> getGoodz(Integer customerReturnListId);

    Integer delete(Integer customerReturnListId);

    String getCustomerByCustomerReturnListId(Integer customerReturnListId);
}
