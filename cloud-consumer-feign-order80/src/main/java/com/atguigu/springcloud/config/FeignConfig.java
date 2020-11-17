package com.atguigu.springcloud.config;/*
 * @Author 裴舒凯
 * @Date 2020-11-17 23:14
 */

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
