package com.example.kafka_demo.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Double price;
    private Integer quantity;

    private Product(ProductBuilder builder) {
        this.productName = builder.productName;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    public static class ProductBuilder {

        private String productName;
        private Double price;
        private Integer quantity;

        public ProductBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}