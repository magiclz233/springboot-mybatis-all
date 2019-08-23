package com.magic.RabbitMQ;

import com.magic.mq.sender.FanoutSender;
import com.magic.mq.sender.OneByOneSender;
import com.magic.mq.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName RabbitMQTest
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/22 10:20
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private OneByOneSender oneByOneSender;

    @Autowired
    TopicSender topicSender;

    @Autowired
    FanoutSender fanoutSender;
    @Test
    public void oneByOneTest(){
        oneByOneSender.send();
    }

    @Test
    public void topicSenderTest(){
        topicSender.topicSend1();
        topicSender.topicSend2();
        topicSender.topicSend3();
    }

    @Test
    public void fanoutSenderTest(){
        fanoutSender.fanSender1();
        fanoutSender.fanSender2();
    }
}
