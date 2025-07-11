package com.study.springboot.restaurant.dto;

import com.study.springboot.restaurant.entity.Menu;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MenuResponse {
    
    private Long id;
    private String name;
    private Integer price;
    private Boolean isRecommended;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public static MenuResponse from(Menu menu) {
        if (menu == null) {
            throw new RuntimeException("메뉴 정보가 null입니다.");
        }
        
        MenuResponse response = new MenuResponse();
        response.setId(menu.getId());
        response.setName(menu.getName());
        response.setPrice(menu.getPrice());
        response.setIsRecommended(menu.getIsRecommended());
        response.setCreatedAt(menu.getCreatedAt());
        response.setUpdatedAt(menu.getUpdatedAt());
        return response;
    }
} 