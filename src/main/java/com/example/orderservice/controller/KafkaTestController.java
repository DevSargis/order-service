package com.example.orderservice.controller;

import com.example.orderservice.service.KafkaMessageProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaTestController {

    private final KafkaMessageProducer producer;

    public KafkaTestController(KafkaMessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String send(@RequestParam String topic, @RequestParam String message) {
        producer.sendTestMessage(topic, message);
        return "Sent message to topic: " + topic;
    }
}
