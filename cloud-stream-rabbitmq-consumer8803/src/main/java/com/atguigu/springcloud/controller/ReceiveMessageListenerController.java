package com.atguigu.springcloud.controller;/*
 * @Author 裴舒凯
 * @Date 2021-01-23 18:54
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)//绑定
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)//监听
    public void input(Message<String> message){
        System.out.println("消费者--->接受到的消息是："+message.getPayload()+""+serverPort);
    }
}
