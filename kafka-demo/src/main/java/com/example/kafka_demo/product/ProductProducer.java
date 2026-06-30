package com.example.kafka_demo.product;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ProductProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(ProductEvent event) {
        kafkaTemplate.send("product-topic", event.getProductName(), event );
        System.out.println("Sent To Kafka : " + event.getProductName());
    }
}
