package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.PurchaseListGoodsSaveDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.PurchaseListGoodsSaveService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


@Service
public class PurchaseListGoodsSaveServiceImpl implements PurchaseListGoodsSaveService {

    @Autowired
    private PurchaseListGoodsSaveDao purchaseListGoodsSaveDao;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private LogService logService;

    @Override
    public ServiceVO purchaseListGoodsSave(String purchaseListGoodsStr,Integer purchaseListId) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<PurchaseListGoods>>() {}.getType();
        List<PurchaseListGoods> purchaseListGoods = gson.fromJson(purchaseListGoodsStr, type);
        for (PurchaseListGoods purchaseListGood : purchaseListGoods) {
            // 1.进货入库
            purchaseListGood.setPurchaseListId(purchaseListId);
            this.purchaseListGoodsSaveDao.purchaseListGoodsSave(purchaseListGood);
            // 2.库存更新
            updateStock(purchaseListGood);
        }
        return  new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }

    /**
     * 更新Goods库存
     * @param purchaseListGood
     */
    private void updateStock(PurchaseListGoods purchaseListGood) {
        Integer goodsId = purchaseListGood.getGoodsId();
        Integer addInventoryQuantity = purchaseListGood.getGoodsNum();
        double purchasingPrice = purchaseListGood.getPrice();
        Goods goods = goodsDao.findByGoodsId(goodsId);
        // 未入库之前 库存
        Integer oldInventoryQuantity = goods.getInventoryQuantity();
        Integer inventoryQuantity = addInventoryQuantity + oldInventoryQuantity;
        goods.setInventoryQuantity(inventoryQuantity);
        goods.setPurchasingPrice(purchasingPrice);
        goodsDao.updateGoods(goods);
        logService.save(new Log(Log.UPDATE_ACTION,goods.getGoodsName()+"商品期初入库"));
    }
}
