//package com.magic.mq;
//
//import com.sun.org.apache.regexp.internal.RE;
//import lombok.Data;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @ClassName RabbitConfig
// * @Author 罗璋||luozhang@cnpc.com.cn
// * Description TODO
// * @Date 2019/8/22 9:19
// * @Version 1.0
// */
//@Configuration
//public class RabbitConfig {
//
//    private static final String QUEUE_NAME = "spring-boot";
//    private static final String MESSAGE = "topic.message";
//    private static final String MESSAGES = "topic.messages";
//    @Bean
//    public Queue queue(){
//        return new Queue(QUEUE_NAME,false);
//    }
//
//    @Bean
//    public Queue message(){
//        return new Queue(MESSAGE);
//    }
//    @Bean
//    public Queue messages(){
//        return new Queue(MESSAGES);
//    }
//    @Bean
//    TopicExchange exchange(){
//        return new TopicExchange("topicExchange");
//    }
//    @Bean
//    TopicExchange exchange1(){
//        return new TopicExchange("exchange");
//    }
//
//
//    @Bean
//    Binding bindingMessage(){
//        return BindingBuilder.bind(message()).to(exchange()).with("topic.message");
//    }
//    @Bean
//    Binding bindingMessages(){
//        return BindingBuilder.bind(messages()).to(exchange()).with("topic.#");
//    }
//
////    @Bean
////    SimpleMessageListenerContainer container(ConnectionFactory factory, MessageListenerAdapter adapter){
////        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
////        container.setConnectionFactory(factory);
////        container.setQueueNames(QUEUE_NAME);
////        container.setMessageListener(adapter);
////        return container;
////    }
//
//}
