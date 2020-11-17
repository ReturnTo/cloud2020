package com.atguigu.springcloud.service;/*
 * @Author 裴舒凯
 * @Date 2020-11-17 21:37
 */

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//微服务名称
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")//方法（跟我们8001中的接口方法一致）
    public CommonResult getPaymentById(@PathVariable("id") Long id);


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();


}
