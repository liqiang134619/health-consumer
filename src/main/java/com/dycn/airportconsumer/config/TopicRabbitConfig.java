//package com.dycn.airportconsumer.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author Liq
// * @date 2021/3/26
// */
//@Configuration
//public class TopicRabbitConfig {
//
//
//
//    //创建队列
//    @Bean(name = "queuemessage")
//    public  Queue queuemessage(){
//        return new Queue("topic.message");
//
//    }
//
//
//    //创建交换机
//    @Bean
//    public TopicExchange exchange(){
//        return new TopicExchange("exchange");
//    }
//
//
//    //绑定队列
//    @Bean
//    Binding binding1(@Qualifier("queuemessage")Queue queuemessage, TopicExchange exchange){
//        return BindingBuilder.bind(queuemessage).to(exchange).with("topic.message");
//    }
//
//}
