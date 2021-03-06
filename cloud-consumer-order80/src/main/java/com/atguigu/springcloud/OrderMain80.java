package com.atguigu.springcloud;
import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 裴舒凯
 */
@SpringBootApplication
@EnableEurekaClient
/**
 * 在启动该微服务的时候就能去加载我们的自定义ribbon配置类，从而使配置生效
 * name：我们去调用哪个微服务（服务提供者）
 * configuration：配置类
 */
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
