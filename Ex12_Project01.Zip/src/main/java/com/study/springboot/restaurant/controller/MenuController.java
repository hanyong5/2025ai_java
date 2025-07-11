package com.study.springboot.restaurant.controller;

import com.study.springboot.restaurant.dto.MenuRequest;
import com.study.springboot.restaurant.dto.MenuResponse;
import com.study.springboot.restaurant.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {
    
    private final MenuService menuService;
    
    @PostMapping("/restaurant/{restaurantId}")
    public ResponseEntity<MenuResponse> createMenu(
            @PathVariable(name = "restaurantId") Long restaurantId,
            @RequestBody MenuRequest request) {
        MenuResponse response = menuService.createMenu(restaurantId, request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{menuId}")
    public ResponseEntity<MenuResponse> getMenu(@PathVariable(name = "menuId") Long menuId) {
        MenuResponse response = menuService.getMenu(menuId);
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<MenuResponse>> getMenusByRestaurant(@PathVariable(name = "restaurantId") Long restaurantId) {
        List<MenuResponse> responses = menuService.getMenusByRestaurant(restaurantId);
        return ResponseEntity.ok(responses);
    }
    
    @GetMapping("/restaurant/{restaurantId}/recommended")
    public ResponseEntity<List<MenuResponse>> getRecommendedMenusByRestaurant(@PathVariable(name = "restaurantId") Long restaurantId) {
        List<MenuResponse> responses = menuService.getRecommendedMenusByRestaurant(restaurantId);
        return ResponseEntity.ok(responses);
    }
    
    @PutMapping("/{menuId}")
    public ResponseEntity<MenuResponse> updateMenu(
            @PathVariable(name = "menuId") Long menuId,
            @RequestBody MenuRequest request) {
        MenuResponse response = menuService.updateMenu(menuId, request);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable(name = "menuId") Long menuId) {
        menuService.deleteMenu(menuId);
        return ResponseEntity.ok().build();
    }
} 