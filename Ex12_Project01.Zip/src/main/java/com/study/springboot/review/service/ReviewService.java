package com.study.springboot.review.service;

import com.study.springboot.member.entity.Member;
import com.study.springboot.member.repository.MemberRepository;
import com.study.springboot.restaurant.entity.Restaurant;
import com.study.springboot.restaurant.repository.RestaurantRepository;
import com.study.springboot.review.dto.ReviewRequest;
import com.study.springboot.review.dto.ReviewResponse;
import com.study.springboot.review.entity.Review;
import com.study.springboot.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;
    
    @Transactional
    public ReviewResponse createReview(Long memberId, Long restaurantId, ReviewRequest request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
        
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        // 별점 범위 체크
        if (request.getRating() < 1 || request.getRating() > 5) {
            throw new RuntimeException("별점은 1~5점 사이여야 합니다.");
        }
        
        Review review = Review.builder()
                .comment(request.getComment())
                .rating(request.getRating())
                .isRecommended(request.getIsRecommended())
                .member(member)
                .restaurant(restaurant)
                .build();
        
        Review savedReview = reviewRepository.save(review);
        return ReviewResponse.from(savedReview);
    }
    
    public ReviewResponse getReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 리뷰입니다."));
        
        return ReviewResponse.from(review);
    }
    
    public Page<ReviewResponse> getReviewsByRestaurant(Long restaurantId, Pageable pageable) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        return reviewRepository.findByRestaurant(restaurant, pageable)
                .map(ReviewResponse::from);
    }
    
    public List<ReviewResponse> getReviewsByMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
        
        return reviewRepository.findByMember(member).stream()
                .map(ReviewResponse::from)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public ReviewResponse updateReview(Long reviewId, Long memberId, ReviewRequest request) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 리뷰입니다."));
        
        // 권한 체크 (리뷰 작성자만 수정 가능)
        if (!review.getMember().getId().equals(memberId)) {
            throw new RuntimeException("리뷰를 수정할 권한이 없습니다.");
        }
        
        // 별점 범위 체크
        if (request.getRating() < 1 || request.getRating() > 5) {
            throw new RuntimeException("별점은 1~5점 사이여야 합니다.");
        }
        
        review.setComment(request.getComment());
        review.setRating(request.getRating());
        review.setIsRecommended(request.getIsRecommended());
        
        return ReviewResponse.from(review);
    }
    
    @Transactional
    public void deleteReview(Long reviewId, Long memberId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 리뷰입니다."));
        
        // 권한 체크 (리뷰 작성자만 삭제 가능)
        if (!review.getMember().getId().equals(memberId)) {
            throw new RuntimeException("리뷰를 삭제할 권한이 없습니다.");
        }
        
        reviewRepository.delete(review);
    }
    
    public Double getAverageRatingByRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        return reviewRepository.getAverageRatingByRestaurant(restaurant);
    }
    
    public Long getRecommendedCountByRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        return reviewRepository.getRecommendedCountByRestaurant(restaurant);
    }
} 