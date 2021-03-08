package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerReturnListDao;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerReturnListGoodsServiceImpl implements CustomerReturnListGoodsService {

    @Autowired
    private CustomerReturnListDao customerReturnListDao;



    @Override
    public Map<String, Object> queryReturnList(Integer returnNumber, Integer customerId, Integer state, Integer state1, String sTime,String etime) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",customerReturnListDao.queryReturn(returnNumber,customerId,state,sTime,etime));
        return map ;
    }

    @Override
    public Map<String, Object> goodsList(Integer customerReturnListId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",customerReturnListDao.getGoodz(customerReturnListId));
        return map;
    }
}
