package com.study.spring.board.repository;

import com.study.spring.board.entity.Post;
import com.study.spring.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    // 전체 게시글 목록 조회 (페이징)
    Page<Post> findAllByOrderByCreatedAtDesc(Pageable pageable);
    
    // 특정 회원의 게시글 목록 조회
    List<Post> findByMemberOrderByCreatedAtDesc(Member member);
    
    // 특정 회원의 게시글 목록 조회 (페이징)
    Page<Post> findByMemberOrderByCreatedAtDesc(Member member, Pageable pageable);
    
    // 제목으로 게시글 검색
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword% ORDER BY p.createdAt DESC")
    Page<Post> findByTitleContaining(@Param("keyword") String keyword, Pageable pageable);
    
    // 내용으로 게시글 검색
    @Query("SELECT p FROM Post p WHERE p.content LIKE %:keyword% ORDER BY p.createdAt DESC")
    Page<Post> findByContentContaining(@Param("keyword") String keyword, Pageable pageable);
    
    // 제목 또는 내용으로 게시글 검색
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword% ORDER BY p.createdAt DESC")
    Page<Post> findByTitleOrContentContaining(@Param("keyword") String keyword, Pageable pageable);
    
    // 작성자 닉네임으로 게시글 검색
    @Query("SELECT p FROM Post p WHERE p.member.nickname LIKE %:nickname% ORDER BY p.createdAt DESC")
    Page<Post> findByMemberNicknameContaining(@Param("nickname") String nickname, Pageable pageable);
    
    // 게시글 존재 여부 확인
    boolean existsByIdAndMember(Long postId, Member member);
    
    // 특정 회원이 작성한 게시글 수 조회
    long countByMember(Member member);
    
    // 전체 게시글 수 조회
    @Query("SELECT COUNT(p) FROM Post p")
    long countAllPosts();
    
    // 최근 게시글 목록 조회 (최신순, 제한된 개수)
    List<Post> findTop10ByOrderByCreatedAtDesc();
    
    // 특정 회원의 최근 게시글 목록 조회
    List<Post> findTop5ByMemberOrderByCreatedAtDesc(Member member);
} 