package com.study.springboot.restaurant.dto;

import com.study.springboot.restaurant.entity.Restaurant;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RestaurantResponse {
    
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String description;
    private Long memberId;
    private String memberNickname;
    private List<MenuResponse> menus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public static RestaurantResponse from(Restaurant restaurant) {
        RestaurantResponse response = new RestaurantResponse();
        response.setId(restaurant.getId());
        response.setName(restaurant.getName());
        response.setAddress(restaurant.getAddress());
        response.setPhoneNumber(restaurant.getPhoneNumber());
        response.setDescription(restaurant.getDescription());
        response.setMemberId(restaurant.getMember().getId());
        response.setMemberNickname(restaurant.getMember().getNickname());
        response.setMenus(restaurant.getMenus().stream()
                .map(MenuResponse::from)
                .collect(Collectors.toList()));
        response.setCreatedAt(restaurant.getCreatedAt());
        response.setUpdatedAt(restaurant.getUpdatedAt());
        return response;
    }
} 