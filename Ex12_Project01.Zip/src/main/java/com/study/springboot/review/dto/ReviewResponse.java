package com.study.springboot.review.dto;

import com.study.springboot.review.entity.Review;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewResponse {
    
    private Long id;
    private String comment;
    private Integer rating;
    private Boolean isRecommended;
    private Long memberId;
    private String memberNickname;
    private Long restaurantId;
    private String restaurantName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public static ReviewResponse from(Review review) {
        ReviewResponse response = new ReviewResponse();
        response.setId(review.getId());
        response.setComment(review.getComment());
        response.setRating(review.getRating());
        response.setIsRecommended(review.getIsRecommended());
        response.setMemberId(review.getMember().getId());
        response.setMemberNickname(review.getMember().getNickname());
        response.setRestaurantId(review.getRestaurant().getId());
        response.setRestaurantName(review.getRestaurant().getName());
        response.setCreatedAt(review.getCreatedAt());
        response.setUpdatedAt(review.getUpdatedAt());
        return response;
    }
} 