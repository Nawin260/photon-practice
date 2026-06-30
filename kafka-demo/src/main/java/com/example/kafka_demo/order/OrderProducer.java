package com.example.kafka_demo.order;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void send(Order order) {
        kafkaTemplate.send("order-topic", order.getKey(), order);
        System.out.println("Message Published : Key=" + order.getKey() + " Value=" + order);
    }
}