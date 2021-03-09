package com.atguigu.jxc.vo;

import lombok.Data;

@Data
public class ReturnListGoodsVo {

    private String number;
    private String date;
    private String supplierName;
    private String code;
    private String name;
    private String model;
    private String goodsType;
    private String unit;
    private Double price;
    private Integer goods_num;
    private Integer total;

}
