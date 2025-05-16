package com.study.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.spring.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	  // 방법 1: JPQL + JOIN FETCH
//    @Query("SELECT m FROM Member m LEFT JOIN FETCH m.memberRoleList WHERE m.email = :email")
//    Optional<Member> findByEmailWithRoles(@Param("email") String email);

    // 방법 2: EntityGraph
//    @EntityGraph(attributePaths = "memberRoleList")
//    Optional<Member> findByEmail(String email);
    
    
 // 방법 2: EntityGraph
    @EntityGraph(attributePaths = "memberRoleList")
    Optional<Member> findByEmail(String email);
    
//    @EntityGraph(attributePaths = {"memberRoleList"})
//    @Query("select m from Member m where m.email = :email")
//    Member getWithRoles(@Param("email") String email); 
    
}
