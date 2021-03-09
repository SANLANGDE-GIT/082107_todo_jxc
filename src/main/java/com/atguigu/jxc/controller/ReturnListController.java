package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.ReturnListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReturnListController {

    @Autowired
    private ReturnListService returnListService;

    @PostMapping("returnListGoods/count")
    @RequiresPermissions("商品采购统计")
    public String returnGoodCount(String sTime, String eTime ,Integer goodsTypeId, String codeOrName){
        return this.returnListService.returnGoodCount(sTime, eTime, goodsTypeId, codeOrName);
    }

    /**
     * 退货单列表展示
     * @param returnNumber 退货单号
     * @param supplierId 供应商id
     * @param state 状态,1表示已退，2表示未退
     * @param sTime 起始时间
     * @param eTime 结束时间
     * @return
     */
    @PostMapping("returnListGoods/list")
    @RequiresPermissions("退货单据查询")
    public Map<String,Object> returnList(String returnNumber,Integer supplierId, Integer state,String sTime,String eTime){

        return returnListService.list(returnNumber,supplierId,state,sTime,eTime);

    }
    @PostMapping("returnListGoods/goodsList")
    @RequiresPermissions("退货单据查询")
    public Map<String,Object> returnListGoods(Integer returnListId){
        return returnListService.listGoods(returnListId);
    }

    @PostMapping("returnListGoods/delete")
    @RequiresPermissions("退货单据查询")
    public ServiceVO deleteReturnList(Integer returnListId){
        return returnListService.deleteReturnList(returnListId);
    }


}
