package com.example.kafka_demo.review;

import com.example.kafka_demo.order.OrderRepository;
import com.example.kafka_demo.product.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final OrderRepository orderRepository;
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewService(OrderRepository orderRepository, ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public ResponseEntity<?> createReview(Long id, Review review) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("No Order Found");
        }
        if (!productRepository.existsById(review.getProductId())) {
            return ResponseEntity.badRequest().body("Product not found");
        }
        Review savedReview = reviewRepository.save(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReview);
    }
}
