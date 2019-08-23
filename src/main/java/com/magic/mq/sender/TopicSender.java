package com.magic.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @ClassName TopicSender
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/22 11:27
 * @Version 1.0
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
   public void topicSend1(){
       Date date = new Date();
       String dateString = new SimpleDateFormat("yyyy-mm-DD hh:MM:ss").format(date);
       dateString = "[topic.msg] Send1 msg:" + dateString;
       System.out.println(dateString);
       this.rabbitTemplate.convertAndSend("topicExchange","topic.msg",dateString);
   }

    public void topicSend2(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-mm-DD hh:MM:ss").format(date);
        dateString = "[topic.good.msg] Send2 msg:" + dateString;
        System.out.println(dateString);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.good.msg",dateString);
    }

    public void topicSend3(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-mm-DD hh:MM:ss").format(date);
        dateString = "[topic.m.z] Send3 msg:" + dateString;
        System.out.println(dateString);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.m.z",dateString);
    }
}
