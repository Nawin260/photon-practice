package com.example.kafka_demo.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEvent {

    private String productName;
    private Double price;
    private Integer quantity;

}