package com.example.orderservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaMessageProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTestMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
