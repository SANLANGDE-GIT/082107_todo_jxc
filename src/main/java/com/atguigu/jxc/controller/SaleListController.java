package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.service.SaleListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SaleListController {

    @Autowired
    private SaleListService saleListService;

    @PostMapping("saleListGoods/save")
    @ResponseBody
    public ServiceVO saveSale(SaleList saleList, String saleListGoodsStr){
        return this.saleListService.saveSale(saleList,saleListGoodsStr);
    }

}
