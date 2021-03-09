package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListDao;
import com.atguigu.jxc.domain.ErrorCode;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.service.ReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<ReturnList> returnListGoodsList =returnListDao.list(returnNumber,supplierId,state,sTime,eTime);
        map.put("rows",returnListGoodsList);
        return map;
    }

    @Override
    public Map<String, Object> listGoods(Integer returnListId) {
        Map<String,Object> map = new HashMap<>();
        List<ReturnListGoods> list =returnListDao.listGoods(returnListId);
        map.put("rows",list);
        return map;
    }

    @Transactional
    @Override
    public ServiceVO deleteReturnList(Integer returnListId) {

        try {
            if (this.returnListDao.deleteReturnListGoods(returnListId)>0) {
                this.returnListDao.deleteReturnList(returnListId);
                return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("操作数据库异常");
        }
        return new ServiceVO(ErrorCode.PARA_TYPE_ERROR_CODE,"删除失败！");
    }
}
