package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 裴舒凯
 */

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced//开启resultTemplate的负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
