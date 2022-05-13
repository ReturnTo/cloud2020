package com.atguigu.springcloud.alibaba.controller;/*
 * @Author 裴舒凯
 * @Date 2021-03-12 16:54
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String   testA(){

    return "testA";
    }


    @GetMapping("/testB")
    public String   testB(){

        return "testB";
    }

    /**
     *
     * @param p1 参数
     * @param p2 参数
     *                          唯一标识                        兜底方法
     *  @SentinelResource(value = "testHotkey",blockHandler = "deal_testHotkey")
     */
    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "deal_testHotkey")
    public String testHotkey(@RequestParam(value = "p1",required = false)String p1,
            @RequestParam(value = "p2",required = false)String p2){


        return "------------testHotkey";
    }

    /**
     *
     * @param p1 兜底方法接收的参数
     * @param p2 兜底方法接收的参数
     * @param exception   兜底方法接收的的异常对象
     * @return
     */
    public String deal_testHotkey(String p1, String p2, BlockException exception){

        return "------------testHotkey//////错误兜底";
    }


}
