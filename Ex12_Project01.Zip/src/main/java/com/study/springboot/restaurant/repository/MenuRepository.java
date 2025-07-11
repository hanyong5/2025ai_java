package com.study.springboot.restaurant.repository;

import com.study.springboot.restaurant.entity.Menu;
import com.study.springboot.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    
    List<Menu> findByRestaurant(Restaurant restaurant);
    
    List<Menu> findByRestaurantAndIsRecommendedTrue(Restaurant restaurant);
} 