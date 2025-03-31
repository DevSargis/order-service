package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderKafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(Order order) {
        kafkaTemplate.send("order-events", order);
    }
}
