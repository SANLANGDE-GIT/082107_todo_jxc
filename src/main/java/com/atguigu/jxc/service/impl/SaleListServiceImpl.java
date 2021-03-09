package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.SaleListDao;
import com.atguigu.jxc.domain.ErrorCode;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.interceptor.LoginInterceptor;
import com.atguigu.jxc.service.SaleListService;
import com.atguigu.jxc.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SaleListServiceImpl implements SaleListService {

    @Autowired
    private SaleListDao saleListDao;

    @Autowired
    private GoodsDao goodsDao;

    @Override
    @Transactional
    public ServiceVO saveSale(SaleList saleList, String saleListGoodsStr) {

        if(saleList==null || StringUtil.isEmpty(saleListGoodsStr))
            return new ServiceVO(ErrorCode.PARA_TYPE_ERROR_CODE,ErrorCode.PARA_TYPE_ERROR_MESS);


        saleList.setUserId(LoginInterceptor.getUserInfo().getUserId());

        Gson gson = new Gson();
        List<SaleListGoods> listGoodsList = gson.fromJson(saleListGoodsStr,new TypeToken<List<SaleListGoods>>(){}.getType());
        if (!this.checkGoodsStore(listGoodsList)) {
            if (this.saleListDao.saveSale(saleList)>0) {
                this.saleListDao.saveSaleListGoods(listGoodsList,saleList.getSaleListId());
                //TODO:减库存
                this.substractGood(listGoodsList);
                return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
            }
        }

        return null;
    }

    private void substractGood(List<SaleListGoods> listGoodsList) {
        listGoodsList.forEach(saleListGoods -> {
            Goods goods = this.goodsDao.findByGoodsId(saleListGoods.getGoodsId());
            Integer inventoryQuantity = goods.getInventoryQuantity();
            goods.setInventoryQuantity(inventoryQuantity-saleListGoods.getGoodsNum());
            this.goodsDao.updateGoods(goods);
        });
    }


    private Boolean checkGoodsStore(List<SaleListGoods> listGoodsList) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            return listGoodsList.stream().anyMatch(saleListGoods ->
                    this.goodsDao.findByGoodsId(saleListGoods.getGoodsId()).getInventoryQuantity() - saleListGoods.getGoodsNum() <0 );
        } finally {
            lock.unlock();
        }

    }
}
