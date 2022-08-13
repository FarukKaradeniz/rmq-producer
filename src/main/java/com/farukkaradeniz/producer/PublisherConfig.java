package com.farukkaradeniz.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {

    @Value("${rmq.queue.omer}")
    private String queueOmer;
    @Value("${rmq.ex.omer}")
    private String omerEx;
    @Value("${rmq.routing.omer}")
    private String omerRouting;

    @Bean
    public Queue queueOmer() {
        return new Queue(queueOmer, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(omerEx);
    }

    @Bean
    Binding omerBinding(Queue omerQueue, DirectExchange exchange) {
        return BindingBuilder.bind(omerQueue)
                .to(exchange)
                .with(omerRouting);
    }

}
