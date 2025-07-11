package com.study.springboot.restaurant.service;

import com.study.springboot.member.entity.Member;
import com.study.springboot.member.repository.MemberRepository;
import com.study.springboot.restaurant.dto.RestaurantRequest;
import com.study.springboot.restaurant.dto.RestaurantResponse;
import com.study.springboot.restaurant.entity.Restaurant;
import com.study.springboot.restaurant.repository.RestaurantRepository;
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
public class RestaurantService {
    
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;
    
    @Transactional
    public RestaurantResponse createRestaurant(Long memberId, RestaurantRequest request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
        
        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .description(request.getDescription())
                .member(member)
                .build();
        
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantResponse.from(savedRestaurant);
    }
    
    public RestaurantResponse getRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        return RestaurantResponse.from(restaurant);
    }
    
    public Page<RestaurantResponse> getAllRestaurants(Pageable pageable) {
        return restaurantRepository.findAll(pageable)
                .map(RestaurantResponse::from);
    }
    
    public Page<RestaurantResponse> searchRestaurants(String keyword, Pageable pageable) {
        return restaurantRepository.findByNameContainingOrAddressContaining(keyword, keyword, pageable)
                .map(RestaurantResponse::from);
    }
    
    public List<RestaurantResponse> getRestaurantsByMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
        
        return restaurantRepository.findByMember(member).stream()
                .map(RestaurantResponse::from)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public RestaurantResponse updateRestaurant(Long restaurantId, Long memberId, RestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        // 권한 체크 (맛집 등록자만 수정 가능)
        if (!restaurant.getMember().getId().equals(memberId)) {
            throw new RuntimeException("맛집을 수정할 권한이 없습니다.");
        }
        
        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setPhoneNumber(request.getPhoneNumber());
        restaurant.setDescription(request.getDescription());
        
        return RestaurantResponse.from(restaurant);
    }
    
    @Transactional
    public void deleteRestaurant(Long restaurantId, Long memberId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 맛집입니다."));
        
        // 권한 체크 (맛집 등록자만 삭제 가능)
        if (!restaurant.getMember().getId().equals(memberId)) {
            throw new RuntimeException("맛집을 삭제할 권한이 없습니다.");
        }
        
        restaurantRepository.delete(restaurant);
    }
} 