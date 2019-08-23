package com.magic.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName TopicConfig
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/22 14:46
 * @Version 1.0
 */
@Configuration
public class TopicConfig {

    @Bean
    public Queue topicQueue1(){
        return new Queue("topic.a");
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue("topic.b");
    }
    @Bean
    public Queue topicQueue3(){
        return new Queue("topic.c");
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.msg");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.#");
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(topicQueue3()).to(topicExchange()).with("topic.*.z");
    }
}
