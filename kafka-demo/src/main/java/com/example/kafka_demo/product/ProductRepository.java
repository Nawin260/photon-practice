package com.example.kafka_demo.product;

import com.example.kafka_demo.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
    Product findAllById(Long id);

}
