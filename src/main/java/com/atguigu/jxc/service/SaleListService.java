package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;

public interface SaleListService {
    ServiceVO saveSale(SaleList saleList, String saleListGoodsStr);
}
