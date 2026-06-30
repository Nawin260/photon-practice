package com.example.kafka_demo.product;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductConsumer {

    private final ProductRepository repository;

    public ProductConsumer(ProductRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "product-topic", groupId = "product-group")
    public void consume(ProductEvent event) {

        Product product = new Product.ProductBuilder()
                        .productName(event.getProductName())
                        .price(event.getPrice())
                        .quantity(event.getQuantity())
                        .build();

        repository.save(product);

        System.out.println("Saved Into DB : " + product.getProductName());
    }
}
