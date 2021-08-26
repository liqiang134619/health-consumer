package com.dycn.airportconsumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  配置rabbitmq 消费端可以不用配置
 * @author Liq
 * @date 2021/3/26
 */
@Configuration
public class TopicRabbitConfig {


//    private static final int DEFAULT_CONCURRENT = 10;


    //队列bean的名称
    public static final String PERSON_QUEUE = "person_queue";


    public static final String PERSON_DELETED_QUEUE = "person_deleted_queue";


    /**
     * 交换机的名称
     */
    public static final String PERSON_ROUTING_EXCHANGE = "person_topics_exchange";


    /**
     * 交换机2
     */
    private static  final String DELETED_FACE_EXCHANGE = "deleted_face_exchange";




    @Bean(PERSON_QUEUE)
    public Queue personQueue() {
        return new Queue("person_queue_01");
    }


    @Bean(PERSON_DELETED_QUEUE)
    public Queue personDeletedQueue() {
        return new Queue("person_deleted_queue_01");
    }


    /**
     * 交换机配置
     */
    @Bean(PERSON_ROUTING_EXCHANGE)
    public TopicExchange exchangeTopicsInform() {
        return ExchangeBuilder.topicExchange(PERSON_ROUTING_EXCHANGE).durable(true).build();
    }


    /**
     * 交换机配置
     */
    @Bean(DELETED_FACE_EXCHANGE)
    public TopicExchange exchangeTopicsInform2() {
        return ExchangeBuilder.topicExchange(DELETED_FACE_EXCHANGE).durable(true).build();
    }


    /**
     * 绑定队列到交换机
     * @param queue 队列
     * @param exchange 交换机
     * @return
     */
    @Bean
    public Binding binding2(@Qualifier(PERSON_DELETED_QUEUE) Queue queue, @Qualifier(DELETED_FACE_EXCHANGE) TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("face.deleted");
    }




    /**
     * 绑定队列到交换机
     * @param queue 队列
     * @param exchange 交换机
     * @return
     */
    @Bean
    public Binding binding(@Qualifier(PERSON_QUEUE) Queue queue, @Qualifier(PERSON_ROUTING_EXCHANGE) TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.message");
    }




    /**
     * 设置线程消费的并发数量
     * @param configurer 配置
     * @param connectionFactory 连接工厂
     * @return result
     */
//    @Bean("rabbitMqFactory")
//    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(
//            SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory
//    ) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConcurrentConsumers(DEFAULT_CONCURRENT);
//        factory.setMaxConcurrentConsumers(DEFAULT_CONCURRENT);
//        configurer.configure(factory,connectionFactory);
//        return factory;

//    }


//
//    //创建队列
//    @Bean(name = "queuemessage")
//    public  Queue queuemessage(){
//        return new Queue("topic.message");
//
//    }



//    //创建交换机
//    @Bean
//    public TopicExchange exchange(){
//        return new TopicExchange("exchange");
//    }


    //绑定队列
//    @Bean
//    Binding binding1(@Qualifier("queuemessage") Queue queuemessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queuemessage).to(exchange).with("topic.message");
//    }


}
