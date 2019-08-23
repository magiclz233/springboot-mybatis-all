package com.magic.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName FanoutSender
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/22 15:45
 * @Version 1.0
 */
@Component
public class FanoutSender {

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void fanSender1(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-mm-DD hh:MM:ss").format(date);
        String message = "FanSender1111:"+dateString;
        this.rabbitTemplate.convertAndSend("fanoutExchange","",message);
    }

    public void fanSender2(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-mm-DD hh:MM:ss").format(date);
        String message = "FanSender2222:"+dateString;
        this.rabbitTemplate.convertAndSend("fanoutExchange","",message);
    }
}
