package com.example.kafka_demo.product;

import com.example.kafka_demo.review.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/create-product")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(service.createProduct(request),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductDetailsById(@PathVariable Long id){
        return new ResponseEntity<>(service.getProductDetails(id),HttpStatus.OK);
    }

    @GetMapping("/products/{productId}/reviews")
    public ResponseEntity<?> getReviews(@PathVariable Long productId) {
        List<Review> reviews = service.getReviews(productId);
        if (reviews.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No reviews found for product id: " + productId);
        }
        return ResponseEntity.ok(reviews);
    }
}