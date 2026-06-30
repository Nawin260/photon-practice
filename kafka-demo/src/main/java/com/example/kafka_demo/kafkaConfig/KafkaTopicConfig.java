package com.example.kafka_demo.kafkaConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder.name("kafka_orders").partitions(3).replicas(1).build();
    }

    @Bean
    public NewTopic productTopic() {
        return TopicBuilder.name("product-topic").partitions(3).replicas(1).build();
    }

    @Bean
    public NewTopic orderDLT() {
        return TopicBuilder.name("kafka_orders.DLT").partitions(3).replicas(1).build();
    }

    @Bean
    public NewTopic productDLT() {
        return TopicBuilder.name("product-topic.DLT").partitions(3).replicas(1).build();
    }
}
