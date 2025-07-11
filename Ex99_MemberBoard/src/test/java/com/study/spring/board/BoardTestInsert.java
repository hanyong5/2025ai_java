package com.study.spring.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.board.entity.Post;
import com.study.spring.board.repository.PostRepository;
import com.study.spring.member.entity.Member;
import com.study.spring.member.repository.MemberRepository;

@SpringBootTest
public class BoardTestInsert {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	 public void boardTestInsert() {
        // 실제 DB에 존재하는 memberId로 조회
        Long memberId = 1L;
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 ID가 존재하지 않습니다: " + memberId));

        // 게시글 엔티티 생성
        Post post = Post.builder()
                .title("테스트 게시글 제목")
                .content("테스트 게시글 내용입니다.")
                .member(member)  // 연관관계 설정
                .build();

        // 저장
        postRepository.save(post);

        // 로그 출력
        System.out.println("게시글 저장 완료: " + post.getTitle());
    }
	
}
