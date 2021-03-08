package com.atguigu.jxc.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsList {
/*"customerReturnListGoodsId": 5,    --
            "goodsId": 11,
            "goodsCode": "0003",
            "goodsName": "野生东北黑木耳",
            "goodsModel": "500g装",
            "goodsNum": 5,
            "goodsUnit": "袋",
            "price": 38,
            "total": 190,
            "customerReturnListId": 5,
            "goodsTypeId": 11*/

    private Integer customerReturnListGoodsId;
    private Integer goodsId;
    private Integer goodsCode;
    private String goodsName;
    private String goodsModel;
    private Integer goodsNum;
    private String goodsUnit;
    private BigDecimal price;
    private BigDecimal total;
    private Integer customerReturnListId;
    private Integer goodsTypeId;

}
