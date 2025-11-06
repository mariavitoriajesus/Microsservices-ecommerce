package com.warehouse.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String ORDER_QUEUE = "order-queue";

    @Bean
    public Queue queue() {
        return new Queue(ORDER_QUEUE, true);
    }
}
