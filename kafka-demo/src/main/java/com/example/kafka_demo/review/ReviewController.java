package com.example.kafka_demo.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping("/orders/{id}/create-review")
    public ResponseEntity<?> addProductReview(@PathVariable Long id,  @RequestBody Review review){
        return service.createReview(id, review);
    }

}
