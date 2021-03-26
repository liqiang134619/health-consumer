package com.dycn.airportconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AirportConsumerApplicationTests {


    @Autowired
    private AmqpTemplate template;


    @Test
    public void test() {


        template.convertAndSend("exchange","topic.message","xxxxxxxxxxxxxxxxxxxxx");
    }

}
