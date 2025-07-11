package com.study.spring.member.service;

import com.study.spring.member.dto.MemberLoginRequest;
import com.study.spring.member.dto.MemberResponse;
import com.study.spring.member.dto.MemberSignupRequest;
import com.study.spring.member.entity.Gender;
import com.study.spring.member.entity.Member;
import com.study.spring.member.repository.GenderRepository;
import com.study.spring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final GenderRepository genderRepository;
    private final PasswordEncoder passwordEncoder;
    
    /**
     * 회원가입
     */
    @Transactional
    public MemberResponse signup(MemberSignupRequest request) {
        log.info("회원가입 요청: {}", request.getEmail());
        
        // 이메일 중복 확인
        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
        
        // 닉네임 중복 확인
        if (memberRepository.existsByNickname(request.getNickname())) {
            throw new IllegalArgumentException("이미 사용 중인 닉네임입니다.");
        }
        
        // 성별 정보 조회
        Gender gender = genderRepository.findByName(request.getGender())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 성별입니다."));
        
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        
        // 회원 엔티티 생성
        Member member = new Member();
        member.setEmail(request.getEmail());
        member.setPassword(encodedPassword);
        member.setNickname(request.getNickname());
        member.setGender(gender);
        member.setProfileImageUrl(request.getProfileImageUrl());
        
        // 회원 저장
        Member savedMember = memberRepository.save(member);
        log.info("회원가입 완료: {}", savedMember.getEmail());
        
        return MemberResponse.from(savedMember);
    }
    
    /**
     * 로그인
     */
    public MemberResponse login(MemberLoginRequest request) {
        log.info("로그인 요청: {}", request.getEmail());
        
        // 회원 조회
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다."));
        
        // 비밀번호 확인
        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
        }
        
        log.info("로그인 성공: {}", member.getEmail());
        return MemberResponse.from(member);
    }
    
    /**
     * 회원 정보 조회
     */
    public MemberResponse getMemberInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        
        return MemberResponse.from(member);
    }
    
    /**
     * 이메일 중복 확인
     */
    public boolean checkEmailDuplicate(String email) {
        return memberRepository.existsByEmail(email);
    }
    
    /**
     * 닉네임 중복 확인
     */
    public boolean checkNicknameDuplicate(String nickname) {
        return memberRepository.existsByNickname(nickname);
    }
} 