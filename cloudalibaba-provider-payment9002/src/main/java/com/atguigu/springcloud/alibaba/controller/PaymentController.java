package com.atguigu.springcloud.alibaba.controller;/*
 * @Author 裴舒凯
 * @Date 2021-01-30 15:07
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value="/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){

        return "nacos"+id+ ": "+serverPort;

    }

}
