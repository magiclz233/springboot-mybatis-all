package com.magic.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName FanoutConfig
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/22 15:40
 * @Version 1.0
 */
@Configuration
public class FanoutConfig {

    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanout.a");
    }

    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanout.b");
    }

    @Bean
    public Queue fanoutQueue3(){
        return new Queue("fanout.c");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingFanout1(){
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    Binding bindingFanout2(){
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    @Bean
    Binding bindingFanout3(){
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }
}
