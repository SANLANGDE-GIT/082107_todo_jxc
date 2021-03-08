package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListSaveDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.ReturnListGoodsSaveService;
import com.atguigu.jxc.service.ReturnListSaveService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReturnListSaveServiceImpl implements ReturnListSaveService {

    @Autowired
    private ReturnListSaveDao returnListSaveDao;

    @Autowired
    private ReturnListGoodsSaveService returnListGoodsSaveService;

    @Transactional
    @Override
    public ServiceVO returnListSave(ReturnList returnList, String returnListGoodsStr) {
        this.returnListSaveDao.returnListSave(returnList);
        Integer returnListId = returnList.getReturnListId();
        if (!StringUtils.isEmpty(returnListGoodsStr) || returnListGoodsStr == null){
            this.returnListGoodsSaveService.returnListGoodsSave(returnListGoodsStr,returnListId);
        }
        return  new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }
}
