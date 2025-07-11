package com.study.springboot.member;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.member.entity.Member;
import com.study.springboot.member.repository.MemberRepository;

@SpringBootTest
public class MemberTest {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  public void testMember() {
    Member member = new Member();
    member.setEmail("hanyong5@test.com");
    member.setPassword("1234");
    member.setNickname("hanyong5");
    member.setRole(Member.Role.ADMIN);
    memberRepository.save(member);
  }

}
