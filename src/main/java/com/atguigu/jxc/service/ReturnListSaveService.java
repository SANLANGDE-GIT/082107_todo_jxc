package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.ReturnList;

public interface ReturnListSaveService {
    ServiceVO returnListSave(ReturnList returnList, String returnListGoodsStr);
}
