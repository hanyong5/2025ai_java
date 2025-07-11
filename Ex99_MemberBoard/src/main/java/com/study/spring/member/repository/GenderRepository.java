package com.study.spring.member.repository;

import com.study.spring.member.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Byte> {
    
    // 성별 이름으로 조회
    Optional<Gender> findByName(String name);
    
    // 성별 이름으로 존재 여부 확인
    boolean existsByName(String name);
} 