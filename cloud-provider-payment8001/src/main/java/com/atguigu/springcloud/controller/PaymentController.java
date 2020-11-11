package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 裴舒凯
 */

@RestController
@Slf4j
public class PaymentController {
    /**
     * 1、 @Autowired与@Resource都可以用来装配bean. 都可以写在字段上,或写在setter方法上。
     *
     * 2、 @Autowired默认按类型装配（这个注解是属业spring的），默认情况下必须要求依赖对象必须存在，
     * 如果要允许null值，可以设置它的required属性为false，如：@Autowired(required=false)
     *
     * 3、@Resource（这个注解属于J2EE的），默认按照名称进行装配，名称可以通过name属性进行指定，
     * 如果没有指定name属性，当注解写在字段上时，默认取字段名进行安装名称查找，如果注解写
     * 在setter方法上默认取属性名进行装配。当找不到与名称匹配的bean时才按照类型进行装配。
     * 但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。
     *
     * 推荐使用：@Resource注解在字段上，这样就不用写setter方法了，并且这个注解是属于J2EE的，
     * 减少了与spring的耦合。这样代码看起就比较优雅
     */
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String Serverport;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("**********element:"+element);
        }
        //表名这个微服务下有哪些实例可以获得   我们是8001  所以使用Eureka中注册的CLOUD-PROVIDER-SERVICE来获取
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"---"+instance.getHost()+"----"+instance.getPort()+"---"+instance.getUri());

        }
        return this.discoveryClient;
    }


    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功,ServerPort:"+Serverport,result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);
        System.out.println("11111");
        if(payment != null){
            return new CommonResult(200,"查询成功,ServerPort:"+Serverport,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }



}
