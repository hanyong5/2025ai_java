package com.study.springboot.review.repository;

import com.study.springboot.member.entity.Member;
import com.study.springboot.restaurant.entity.Restaurant;
import com.study.springboot.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    Page<Review> findByRestaurant(Restaurant restaurant, Pageable pageable);
    
    List<Review> findByMember(Member member);
    
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.restaurant = :restaurant")
    Double getAverageRatingByRestaurant(@Param("restaurant") Restaurant restaurant);
    
    @Query("SELECT COUNT(r) FROM Review r WHERE r.restaurant = :restaurant AND r.isRecommended = true")
    Long getRecommendedCountByRestaurant(@Param("restaurant") Restaurant restaurant);
} 