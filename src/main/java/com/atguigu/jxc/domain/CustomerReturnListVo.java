package com.atguigu.jxc.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerReturnListVo {
    /*
     "customerReturnListId": 5,
            "returnNumber": "XT1605773513845",
            "returnDate": "2020-11-19",
            "amountPaid": 190,
            "amountPayable": 190,
            "state": 1,
            "customerId": 3,
            "userId": 1,
            "remarks": "",
            "customerName": "永辉超市（温江光华大道店）",
            "trueName": "兰杰"
    * */
    private Integer customerReturnListId;
    private String returnNumber;
    private String returnDate;
    private BigDecimal amountPaid;
    private BigDecimal amountPayable;
    private Integer state;
    private Integer customerId;
    private Integer userId;
    private String remarks;
    private String customerName;
    private String trueName;


}
