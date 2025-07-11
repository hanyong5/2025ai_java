package com.study.spring.member.repository;

import com.study.spring.member.entity.Gender;
import com.study.spring.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.email = :email")
    Optional<Member> findByEmail(@Param("email") String email); 

    @Query("SELECT m FROM Member m WHERE m.nickname = :nickname")
    Optional<Member> findByNickname(@Param("nickname") String nickname);

    @Query("SELECT m FROM Member m WHERE m.gender = :gender")
    Optional<Member> findByGender(@Param("gender") Gender gender);

    List<Member> findAll();

    @Query("SELECT m FROM Member m WHERE m.id = :id")
    Optional<Member> findById(@Param("id") Long id);

 
    
    // 이메일 중복 확인
    boolean existsByEmail(String email);
    
    // 닉네임 중복 확인
    boolean existsByNickname(String nickname);
    
    // 이메일과 비밀번호로 로그인
    Optional<Member> findByEmailAndPassword(String email, String password);
    

    
    // 이메일 또는 닉네임으로 회원 존재 여부 확인
    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Member m WHERE m.email = :email OR m.nickname = :nickname")
    boolean existsByEmailOrNickname(@Param("email") String email, @Param("nickname") String nickname);
} 