package com.study.springboot.restaurant.dto;

import lombok.Data;

@Data
public class RestaurantRequest {
    
    private String name;
    private String address;
    private String phoneNumber;
    private String description;
} 