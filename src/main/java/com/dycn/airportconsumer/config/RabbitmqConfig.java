package com.dycn.airportconsumer.config;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Liq
 * @date 2021/3/26
 */
@Component
@Slf4j
public class RabbitmqConfig {



    @RabbitListener(queues="topic.message")
    public void processC(String obj, Channel channel, Message message) throws IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("receiver:topic.message:"+obj);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }

}
