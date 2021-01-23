package com.atguigu.springcloud.service.impl;/*
 * @Author 裴舒凯
 * @Date 2021-01-23 16:46
 */

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

//表示我们的管道跟SpringCloudStream建立了连接
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//这个就是我们的管道

    /**
     * 官网实例：
     *      返回一个message
     *     @InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedRate = "5000"))
     *     public Message<?> generate() {
     *         String value = data[RANDOM.nextInt(data.length)];
     *         System.out.println("Sending: " + value);
     *         return MessageBuilder.withPayload(value)
     *                 .setHeader("partitionKey", value)
     *                 .build();
     *     }
     * @return
     */
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*************************** serial:"+serial);
        return null;
    }
}

