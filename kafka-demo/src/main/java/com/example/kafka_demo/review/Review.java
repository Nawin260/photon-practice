package com.example.kafka_demo.review;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private Long productId;

//    @Column(nullable = false)
//    private Long customerId;

    @Column(nullable = false)
    private Integer rating;

    @Column(length = 1000)
    private String reviewMessage;

//    @Column(nullable = false)
//    private Boolean verifiedPurchase;
//
//    @Column(nullable = false)
//    private LocalDateTime reviewDate;
//
//    private LocalDateTime updatedDate;
//
//    private Integer helpfulVotes;
//
//    @Enumerated(EnumType.STRING)
//    private ReviewStatus status;

}
