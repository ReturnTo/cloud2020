package com.atguigu.springcloud.controller;/*
 * @Author 裴舒凯
 * @Date 2021-01-23 17:07
 */

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){

        return messageProvider.send();
    }

}
