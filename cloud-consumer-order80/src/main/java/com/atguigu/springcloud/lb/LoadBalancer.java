package com.atguigu.springcloud.lb;/*
 * @Author 裴舒凯
 * @Date 2020-11-16 20:31
 */

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    //收集服务器总共有多少台能够提供服务的机器，并放到list里面
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
