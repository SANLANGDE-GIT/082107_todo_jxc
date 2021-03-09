package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    private LogService logService;

    @Autowired
    private SaleListGoodsDao saleListGoodsDao;


    @Override
    public Map<String, Object> saleListGoodsList(String saleNumber, Integer customerId, Integer state, String sTime, String eTime) {


        List<SaleList> saleGoods =  saleListGoodsDao.getSaleListGoods(saleNumber,customerId,state,sTime,eTime);
        Map<String, Object> map = new HashMap<>();
        logService.save(new Log(Log.SELECT_ACTION,"销售单查询"));
        map.put("rows",saleGoods);

        return map;

    }

    @Override
    public Map<String, Object> saleListGoodsGoodsList(Integer saleListId) {
        List<SaleListGoods> saleGoods =  saleListGoodsDao.getSaleListGoodsGoods(saleListId);
        Map<String, Object> map = new HashMap<>();
        logService.save(new Log(Log.SELECT_ACTION,"销售单商品信息"));
        map.put("rows",saleListId);
        map.put("rows",saleGoods);
        return map;
    }

        @Override
        public ServiceVO deleteSaleListGoods(Integer saleListId) {

        logService.save(new Log(Log.SELECT_ACTION,"删除销售单商品信息"));

            saleListGoodsDao.deleteSaleListGoods(saleListId);

        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);

    }
}
