package com.study.spring.member.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.study.spring.member.entity.Member;
import com.study.spring.member.entity.MemberRole;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTest {

	@Autowired
	public MemberRepository memberRepository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Test
	public void testInsertMember() {
//		Member member = new Member();
		Member member = Member.builder()
				.email("user1@naver.com")
				.password(passwordEncoder.encode("1111"))
				.nickname("ttomi")
				.build();
		
		member.addRole(MemberRole.USER);
		member.addRole(MemberRole.MANAGER);
		
		
		
		memberRepository.save(member);
		
	}
	
}
