package com.example.kafka_demo.order;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consume(ConsumerRecord<String, Order> record) {

        System.out.println("Partition=" + record.partition() + " Key=" + record.key()
                + " Value=" + record.value()
        );
    }
}
