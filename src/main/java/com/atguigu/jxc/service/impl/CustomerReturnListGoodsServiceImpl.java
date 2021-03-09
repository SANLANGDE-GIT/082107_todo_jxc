package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerReturnListDao;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import com.atguigu.jxc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerReturnListGoodsServiceImpl implements CustomerReturnListGoodsService {

    @Autowired
    private CustomerReturnListDao customerReturnListDao;

    @Autowired
    private LogService logService;



    @Override
    public Map<String, Object> queryReturnList(String returnNumber, Integer customerId, Integer state,String sTime,String eTime) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",customerReturnListDao.queryReturn(returnNumber,customerId,state,sTime,eTime));
        return map ;
    }

    @Override
    public Map<String, Object> goodsList(Integer customerReturnListId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",customerReturnListDao.getGoodz(customerReturnListId));
        return map;
    }

    @Override
    public Integer deleteReturnListBycustomerReturnListId(Integer customerReturnListId) {
        logService.save(new Log(Log.DELETE_ACTION,
                "删除客户:" + customerReturnListDao.getCustomerByCustomerReturnListId(customerReturnListId)));
        return customerReturnListDao.delete(customerReturnListId);
    }
}
