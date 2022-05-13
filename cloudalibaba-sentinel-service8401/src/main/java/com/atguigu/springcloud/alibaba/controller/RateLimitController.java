package com.atguigu.springcloud.alibaba.controller;/*
 * @Author 裴舒凯
 * @Date 2021-04-18 16:00
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleExcception")
    public CommonResult byResult(){
        return new CommonResult(200,"按资源名",new Payment(2020L,"seial001"));
    }

    public CommonResult handleExcception(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName());
    }


    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byR////、、、、、、、、esource")
    public CommonResult byUrl(){
        return new CommonResult(200,"按URL限流",new Payment(2020L,"seial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleExcception2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客户自定义");
    }
}
