package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListDao;
import com.atguigu.jxc.dao.ReturnListGoodsDao;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.atguigu.jxc.service.ReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReturnListServiceImpl implements ReturnListService {

    @Autowired
    private ReturnListDao returnListDao;

    @Override
    public Map<String, Object> list(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime) {
        Map<String,Object> map = new HashMap<>();
        List<ReturnListGoods> returnListGoodsList =returnListDao.list(returnNumber,supplierId,state,sTime,eTime);
        map.put("rows",returnListGoodsList);
        return map;
    }
}
