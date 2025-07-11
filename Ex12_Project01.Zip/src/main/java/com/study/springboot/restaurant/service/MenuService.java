package com.study.springboot.restaurant.service;

import com.study.springboot.restaurant.dto.MenuRequest;
import com.study.springboot.restaurant.dto.MenuResponse;
import com.study.springboot.restaurant.entity.Menu;
import com.study.springboot.restaurant.entity.Restaurant;
import com.study.springboot.restaurant.repository.MenuRepository;
import com.study.springboot.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {
    
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    
    @Transactional
    public MenuResponse createMenu(Long restaurantId, MenuRequest request) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        Menu menu = Menu.builder()
                .name(request.getName())
                .price(request.getPrice())
                .isRecommended(request.getIsRecommended())
                .restaurant(restaurant)
                .build();
        
        Menu savedMenu = menuRepository.save(menu);
        return MenuResponse.from(savedMenu);
    }
    
    public MenuResponse getMenu(Long menuId) {
        try {
            Menu menu = menuRepository.findById(menuId)
                    .orElseThrow(() -> new RuntimeException("메뉴 ID " + menuId + "에 해당하는 메뉴를 찾을 수 없습니다."));
            
            return MenuResponse.from(menu);
        } catch (Exception e) {
            throw new RuntimeException("메뉴 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    public List<MenuResponse> getMenusByRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        return menuRepository.findByRestaurant(restaurant).stream()
                .map(MenuResponse::from)
                .collect(Collectors.toList());
    }
    
    public List<MenuResponse> getRecommendedMenusByRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        return menuRepository.findByRestaurantAndIsRecommendedTrue(restaurant).stream()
                .map(MenuResponse::from)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public MenuResponse updateMenu(Long menuId, MenuRequest request) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 메뉴입니다."));
        
        menu.setName(request.getName());
        menu.setPrice(request.getPrice());
        menu.setIsRecommended(request.getIsRecommended());
        
        return MenuResponse.from(menu);
    }
    
    @Transactional
    public void deleteMenu(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 메뉴입니다."));
        
        menuRepository.delete(menu);
    }
} 