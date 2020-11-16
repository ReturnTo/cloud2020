package com.atguigu.springcloud.lb;/*
 * @Author 裴舒凯
 * @Date 2020-11-16 20:37
 */

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer{

    //原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //坐标
    private final int getAndIncrement(){
        int current; //原子类的值，初始为0
        int next;   //修改后的值  也叫做第几次访问  默认都是从0开始，会进行累加
        do {
            //获取原子类的值
            current = this.atomicInteger.get();
            //2147483647为Integer的最大值
            //进行判断，现在是否累加到2147483647  如果是  那就从0开始，如果不是  那么+1
            next = current >= 2147483647 ? 0 : current + 1;
            //如果两个值相同  返回true  不相同返回false   因为取反了  所以会跳出循环
        }while (!this.atomicInteger.compareAndSet(current,next));  //第一个参数是期望值，第二个参数是修改值是
        System.out.println("*******第几次访问，次数next: "+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {  //得到机器的列表
        //调用接口的方法（在controller中把服务器的数据传过来了）   然后获取服务器下标位置
        int index = getAndIncrement() % serviceInstances.size(); //得到服务器的下标位置 进行返回
        return serviceInstances.get(index);
    }

}
