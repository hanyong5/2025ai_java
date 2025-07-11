package com.study.springboot.review.dto;

import lombok.Data;

@Data
public class ReviewRequest {
    
    private String comment;
    private Integer rating; // 1~5점
    private Boolean isRecommended;
} 