package com.magic.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName HelloSender
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/22 10:15
 * @Version 1.0
 */

@Component
public class OneByOneSender {

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "OneByOneSender" + new Date();
        System.out.println("OneSender : " + context);
        this.rabbitTemplate.convertAndSend("OneByOne", context);
    }

}
