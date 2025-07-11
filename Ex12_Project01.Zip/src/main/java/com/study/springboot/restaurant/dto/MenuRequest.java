package com.study.springboot.restaurant.dto;

import lombok.Data;

@Data
public class MenuRequest {
    
    private String name;
    private Integer price;
    private Boolean isRecommended;
} 