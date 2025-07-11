package com.study.spring.member;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.member.entity.Gender;
import com.study.spring.member.entity.Member;
import com.study.spring.member.repository.GenderRepository;
import com.study.spring.member.repository.MemberRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class MemberInsert {

    private static final Object[][] TEST_MEMBERS = {
        {"test1@example.com", "password1", "nickname1", 1},
        {"test2@example.com", "password2", "nickname2", 1},
        {"test3@example.com", "password3", "nickname3", 2},
        {"test4@example.com", "password4", "nickname4", 1},
        {"test5@example.com", "password5", "nickname5", 1},
    };

    @Autowired
    private MemberRepository memberRepository;
    
    private GenderRepository genderRepository;

//    @Test
//    public void testMemberInsert() {
//        // 회원 가입을 위한 테스트 자료 10개를 리스트로 생성
//
//    // 테스트 멤버 데이터를 반복하여 회원을 생성하고 저장합니다.
//    for (Object[] testMember : TEST_MEMBERS) {
//        String email = (String) testMember[0];
//        String password = (String) testMember[1];
//        String nickname = (String) testMember[2];
//        String genderName = (String) testMember[3];
//
//        // GenderRepository가 Autowired 되어 있지 않으므로 수동으로 주입
//        if (genderRepository == null) {
//            genderRepository = 
//                org.springframework.test.util.ReflectionTestUtils.getField(this, "genderRepository") != null
//                ? (GenderRepository) org.springframework.test.util.ReflectionTestUtils.getField(this, "genderRepository")
//                : null;
//        }
//
//        Gender gender = null;
//        if (genderRepository != null) {
//            gender = genderRepository.findByName(genderName).orElse(null);
//        }
//
//        Member member = new Member();
//        member.setEmail(email);
//        member.setPassword(password);
//        member.setNickname(nickname);
//        member.setGender(gender);
//
//        memberRepository.save(member);
//    }
//    }


    
    @Test
    @Transactional
public void memberList() {
    List<Member> memberList = memberRepository.findAll();
    if (memberList == null || memberList.isEmpty()) {
        System.out.println("멤버가 존재하지 않습니다.");
    } else {
        for (Member member : memberList) {
            // 출력 확인용: System.out 사용
            System.out.println(
                "이메일: " + member.getEmail() +
                ", 닉네임: " + member.getNickname() +
                ", 성별: " + (member.getGender() != null ? member.getGender().getName() : "없음") +
                ", 프로필 이미지: " + member.getProfileImageUrl() +
                ", 생성일: " + member.getCreatedAt()
            );
        }
    }
}
}
