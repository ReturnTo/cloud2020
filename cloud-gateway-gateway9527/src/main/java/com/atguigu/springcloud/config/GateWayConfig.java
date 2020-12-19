package com.atguigu.springcloud.config;/*
 * @Author 裴舒凯
 * @Date 2020-12-17 19:06
 */

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    /**
     * 构建路由过滤器
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
         RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
         //创建一个路由    然后id                       断言                    映射的url
         routes.route("path_rote_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
         return routes.build();
     }
}
