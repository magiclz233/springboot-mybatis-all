package com.magic.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SimpleConfig
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/22 16:00
 * @Version 1.0
 */
@Configuration
public class OneByOneConfig {

    @Bean
    public Queue oneQueue(){
        return new Queue("OneByOne");
    }
}
