package com.farukkaradeniz.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    @Value("${rmq.ex.omer}")
    private String omerEx;
    @Value("${rmq.routing.omer}")
    private String omerRouting;

    private final RabbitTemplate rabbitTemplate;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendMessage(String msg) {


        rabbitTemplate.convertAndSend(omerEx, omerRouting, msg);
    }
}
