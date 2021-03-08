package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.ReturnListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnListGoodsController {

    @Autowired
    private ReturnListGoodsService returnListGoodsService;

}
