package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.ReturnListGoodsSaveDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.ReturnListGoodsSaveService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ReturnListGoodsSaveServiceImpl implements ReturnListGoodsSaveService {

    @Autowired
    private ReturnListGoodsSaveDao returnListGoodsSaveDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private LogService logService;

    @Override
    public ServiceVO returnListGoodsSave(String returnListGoodsStr,Integer returnListId) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<ReturnListGoods>>() {}.getType();
        List<ReturnListGoods> returnListGoods = gson.fromJson(returnListGoodsStr, type);
        for (ReturnListGoods returnListGood : returnListGoods) {
            // 1.出货出库
            returnListGood.setReturnListId(returnListId);
            this.returnListGoodsSaveDao.returnListGoodsSave(returnListGood);
            // 2.更新Goods库存
            updateGoodsStock(returnListGood);
        }
        return  new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }

    private void updateGoodsStock(ReturnListGoods returnListGood) {
        Integer goodsId = returnListGood.getGoodsId();
        Integer addInventoryQuantity = returnListGood.getGoodsNum();
        double purchasingPrice = returnListGood.getPrice();
        Goods goods = goodsDao.findByGoodsId(goodsId);

        Integer oldInventoryQuantity = goods.getInventoryQuantity();
        Integer inventoryQuantity = oldInventoryQuantity - addInventoryQuantity;
        goods.setInventoryQuantity(inventoryQuantity);
        goods.setPurchasingPrice(purchasingPrice);
        goodsDao.updateGoods(goods);
        logService.save(new Log(Log.UPDATE_ACTION,goods.getGoodsName()+"商品期初入库"));
    }
}
