package com.study.springboot.restaurant.controller;

import com.study.springboot.common.dto.PageResponse;
import com.study.springboot.restaurant.dto.RestaurantRequest;
import com.study.springboot.restaurant.dto.RestaurantResponse;
import com.study.springboot.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    
    private final RestaurantService restaurantService;
    
    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(
            @RequestParam(name = "memberId") Long memberId,
            @RequestBody RestaurantRequest request) {
        RestaurantResponse response = restaurantService.createRestaurant(memberId, request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantResponse> getRestaurant(@PathVariable(name = "restaurantId") Long restaurantId) {
        RestaurantResponse response = restaurantService.getRestaurant(restaurantId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<PageResponse<RestaurantResponse>> getAllRestaurants(Pageable pageable) {
        Page<RestaurantResponse> page = restaurantService.getAllRestaurants(pageable);
        PageResponse<RestaurantResponse> response = PageResponse.from(page);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/search")
    public ResponseEntity<PageResponse<RestaurantResponse>> searchRestaurants(
            @RequestParam(name = "keyword") String keyword,
            Pageable pageable) {
        Page<RestaurantResponse> page = restaurantService.searchRestaurants(keyword, pageable);
        PageResponse<RestaurantResponse> response = PageResponse.from(page);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantsByMember(@PathVariable(name = "memberId") Long memberId) {
        List<RestaurantResponse> responses = restaurantService.getRestaurantsByMember(memberId);
        return ResponseEntity.ok(responses);
    }
    
    @PutMapping("/{restaurantId}")
    public ResponseEntity<RestaurantResponse> updateRestaurant(
            @PathVariable(name = "restaurantId") Long restaurantId,
            @RequestParam(name = "memberId") Long memberId,
            @RequestBody RestaurantRequest request) {
        RestaurantResponse response = restaurantService.updateRestaurant(restaurantId, memberId, request);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurant(
            @PathVariable(name = "restaurantId") Long restaurantId,
            @RequestParam(name = "memberId") Long memberId) {
        restaurantService.deleteRestaurant(restaurantId, memberId);
        return ResponseEntity.ok().build();
    }
} 