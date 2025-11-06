package com.storefront.service;

import com.storefront.config.RabbitConfig;
import com.storefront.model.Order;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service
public class OrderPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public OrderPublisher(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }
    public void sendOrder(Order order) {
        rabbitTemplate.convertAndSend(RabbitConfig.ORDER_QUEUE, order);
        System.out.println("📦 Pedido enviado para fila RabbitMQ: " + order.getId());
    }
}
