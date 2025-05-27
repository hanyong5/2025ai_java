package com.study.spring.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.spring.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
