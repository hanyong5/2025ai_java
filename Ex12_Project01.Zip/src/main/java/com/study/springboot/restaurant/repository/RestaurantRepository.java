package com.study.springboot.restaurant.repository;

import com.study.springboot.member.entity.Member;
import com.study.springboot.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
    Page<Restaurant> findAll(Pageable pageable);
    
    List<Restaurant> findByMember(Member member);
    
    Page<Restaurant> findByNameContainingOrAddressContaining(String name, String address, Pageable pageable);
} 