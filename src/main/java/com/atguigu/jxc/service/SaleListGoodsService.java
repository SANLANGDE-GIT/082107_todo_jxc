package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import org.springframework.stereotype.Repository;

import java.util.Map;
public interface SaleListGoodsService {


    Map<String, Object> saleListGoodsList(String saleNumber, Integer customerId, Integer state, String sTime, String eTime);

    Map<String, Object> saleListGoodsGoodsList(Integer saleListId);


    ServiceVO deleteSaleListGoods(Integer saleListId);
}
