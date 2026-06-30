package com.example.kafka_demo.product;

import com.example.kafka_demo.review.Review;
import com.example.kafka_demo.review.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductProducer producer;
    private final ProductRepository repository;
    private final ReviewRepository reviewRepository;

    public ProductService(ProductProducer producer, ProductRepository repository, ReviewRepository reviewRepository) {
        this.producer = producer;
        this.repository = repository;
        this.reviewRepository = reviewRepository;
    }

    public String createProduct(ProductRequest request) {

        ProductEvent event = new ProductEvent();
        event.setProductName(request.getProductName());
        event.setPrice(request.getPrice());
        event.setQuantity(request.getQuantity());

        producer.send(event);
        return "Product Sent To Kafka";
    }

    public ProductDTO getProductDetails(Long id) {
        Product product = repository.findAllById(id);
        return new ProductDTO(product.getId(), product.getProductName());
    }

    public List<Review> getReviews(Long productId) {
        List<Review> reviewList = reviewRepository.findByProductId(productId);
        if (reviewList.isEmpty()) {
            throw new RuntimeException("No reviews found for product id: " + productId);
        }
        return reviewList;
    }
}
