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
@RabbitListener(queues = "fanout.b")
public class Fanout2Reciver {

    @RabbitHandler
    public void receiver(String message){
        System.out.println("FanoutReceiver---fanout.b:"+message);
    }
}
