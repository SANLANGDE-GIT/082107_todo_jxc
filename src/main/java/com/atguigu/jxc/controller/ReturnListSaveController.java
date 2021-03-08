package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.ReturnListSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnListSaveController {

    @Autowired
    private ReturnListSaveService returnListSaveService;

    @PostMapping("/returnListGoods/save")
    public ServiceVO ReturnListSave(ReturnList returnList, String returnListGoodsStr){
        return this.returnListSaveService.returnListSave(returnList,returnListGoodsStr);
    }
}
