package com.study.springboot.member.repository;

import com.study.springboot.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    
    Optional<Member> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    boolean existsByNickname(String nickname);
} 