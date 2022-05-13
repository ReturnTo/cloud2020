package com.atguigu.springcloud.alibaba.myhandler;/*
 * @Author 裴舒凯
 * @Date 2021-04-18 18:21
 */

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

public class CustomerBlockHandler {
    public CommonResult handleExcception(BlockException exception){
        return new CommonResult(444,"按客户自定义------------1");
    }

    public CommonResult handleExcception2(BlockException exception){
        return new CommonResult(444,"按客户自定义-------------2");
    }
}
