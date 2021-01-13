package com.atguigu.springcloud.Controller;/*
 * @Author 裴舒凯
 * @Date 2021-01-05 21:48
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    /**
     * config: #config客户端配置
     *       label: master #分支名称
     *       name: config  #配置文件名称
     *       profile: dev  #读取后缀名称  master分支上的config-dev.yml文件被读取
     */
   @Value("${config.info}")
    private String configInfo;

  @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
