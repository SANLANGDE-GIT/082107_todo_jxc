package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.ReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("returnListGoods")
@RestController
public class ReturnListController {

    @Autowired
    private ReturnListService returnListService;

    /**
     * 退货单列表展示
     * @param returnNumber 退货单号
     * @param supplierId 供应商id
     * @param state 状态,1表示已退，2表示未退
     * @param sTime 起始时间
     * @param eTime 结束时间
     * @return
     */
    @PostMapping("list")
    public Map<String,Object> returnListGoods(String returnNumber,Integer supplierId, Integer state,String sTime,String eTime){

        return returnListService.list(returnNumber,supplierId,state,sTime,eTime);

    }

}
