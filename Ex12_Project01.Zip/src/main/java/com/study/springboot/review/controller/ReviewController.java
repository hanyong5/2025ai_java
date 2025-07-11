package com.study.springboot.review.controller;

import com.study.springboot.common.dto.PageResponse;
import com.study.springboot.review.dto.ReviewRequest;
import com.study.springboot.review.dto.ReviewResponse;
import com.study.springboot.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    
    private final ReviewService reviewService;
    
    @PostMapping("/restaurant/{restaurantId}")
    public ResponseEntity<ReviewResponse> createReview(
            @PathVariable(name = "restaurantId") Long restaurantId,
            @RequestParam(name = "memberId") Long memberId,
            @RequestBody ReviewRequest request) {
        ReviewResponse response = reviewService.createReview(memberId, restaurantId, request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable(name = "reviewId") Long reviewId) {
        ReviewResponse response = reviewService.getReview(reviewId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<PageResponse<ReviewResponse>> getReviewsByRestaurant(
            @PathVariable(name = "restaurantId") Long restaurantId,
            Pageable pageable) {
        Page<ReviewResponse> page = reviewService.getReviewsByRestaurant(restaurantId, pageable);
        PageResponse<ReviewResponse> response = PageResponse.from(page);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByMember(@PathVariable(name = "memberId") Long memberId) {
        List<ReviewResponse> responses = reviewService.getReviewsByMember(memberId);
        return ResponseEntity.ok(responses);
    }
    
    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewResponse> updateReview(
            @PathVariable(name = "reviewId") Long reviewId,
            @RequestParam(name = "memberId") Long memberId,
            @RequestBody ReviewRequest request) {
        ReviewResponse response = reviewService.updateReview(reviewId, memberId, request);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(
            @PathVariable(name = "reviewId") Long reviewId,
            @RequestParam(name = "memberId") Long memberId) {
        reviewService.deleteReview(reviewId, memberId);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/restaurant/{restaurantId}/average-rating")
    public ResponseEntity<Double> getAverageRatingByRestaurant(@PathVariable(name = "restaurantId") Long restaurantId) {
        Double averageRating = reviewService.getAverageRatingByRestaurant(restaurantId);
        return ResponseEntity.ok(averageRating);
    }
    
    @GetMapping("/restaurant/{restaurantId}/recommended-count")
    public ResponseEntity<Long> getRecommendedCountByRestaurant(@PathVariable(name = "restaurantId") Long restaurantId) {
        Long recommendedCount = reviewService.getRecommendedCountByRestaurant(restaurantId);
        return ResponseEntity.ok(recommendedCount);
    }
} 