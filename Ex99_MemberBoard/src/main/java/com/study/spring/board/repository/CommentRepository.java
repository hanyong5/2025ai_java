package com.study.spring.board.repository;

import com.study.spring.board.entity.Comment;
import com.study.spring.board.entity.Post;
import com.study.spring.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    // 특정 게시글의 댓글 목록 조회 (최신순)
    List<Comment> findByPostOrderByCreatedAtDesc(Post post);
    
    // 특정 게시글의 댓글 목록 조회 (페이징)
    Page<Comment> findByPostOrderByCreatedAtDesc(Post post, Pageable pageable);
    
    // 특정 게시글의 댓글 수 조회
    long countByPost(Post post);
    
    // 특정 회원이 작성한 댓글 목록 조회
    List<Comment> findByMemberOrderByCreatedAtDesc(Member member);
    
    // 특정 회원이 작성한 댓글 목록 조회 (페이징)
    Page<Comment> findByMemberOrderByCreatedAtDesc(Member member, Pageable pageable);
    
    // 특정 회원이 작성한 댓글 수 조회
    long countByMember(Member member);
    
    // 특정 게시글의 댓글 존재 여부 확인
    boolean existsByPost(Post post);
    
    // 특정 회원이 특정 게시글에 작성한 댓글 존재 여부 확인
    boolean existsByPostAndMember(Post post, Member member);
    
    // 특정 게시글의 댓글 중 특정 회원이 작성한 댓글 조회
    List<Comment> findByPostAndMemberOrderByCreatedAtDesc(Post post, Member member);
    
    // 댓글 내용으로 검색
    @Query("SELECT c FROM Comment c WHERE c.content LIKE %:keyword% ORDER BY c.createdAt DESC")
    Page<Comment> findByContentContaining(@Param("keyword") String keyword, Pageable pageable);
    
    // 특정 게시글의 댓글 중 내용으로 검색
    @Query("SELECT c FROM Comment c WHERE c.post = :post AND c.content LIKE %:keyword% ORDER BY c.createdAt DESC")
    Page<Comment> findByPostAndContentContaining(@Param("post") Post post, @Param("keyword") String keyword, Pageable pageable);
    
    // 특정 회원이 작성한 댓글 중 내용으로 검색
    @Query("SELECT c FROM Comment c WHERE c.member = :member AND c.content LIKE %:keyword% ORDER BY c.createdAt DESC")
    Page<Comment> findByMemberAndContentContaining(@Param("member") Member member, @Param("keyword") String keyword, Pageable pageable);
    
    // 최근 댓글 목록 조회 (최신순, 제한된 개수)
    List<Comment> findTop20ByOrderByCreatedAtDesc();
    
    // 특정 게시글의 최근 댓글 목록 조회
    List<Comment> findTop10ByPostOrderByCreatedAtDesc(Post post);
    
    // 특정 회원의 최근 댓글 목록 조회
    List<Comment> findTop10ByMemberOrderByCreatedAtDesc(Member member);
    
    // 전체 댓글 수 조회
    @Query("SELECT COUNT(c) FROM Comment c")
    long countAllComments();
} 