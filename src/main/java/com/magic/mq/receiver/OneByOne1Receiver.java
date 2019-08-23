package com.magic.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloReciver
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/22 10:18
 * @Version 1.0
 */

@Component
@RabbitListener(queues = "OneByOne")
public class OneByOne1Receiver {

    @RabbitHandler
    public void receiver(String context){
        System.out.println("OneByOne1-Receiver::::"+context);
    }
}
