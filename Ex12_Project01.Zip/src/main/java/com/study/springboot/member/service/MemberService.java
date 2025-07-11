package com.study.springboot.member.service;

import com.study.springboot.member.dto.MemberLoginRequest;
import com.study.springboot.member.dto.MemberResponse;
import com.study.springboot.member.dto.MemberSignupRequest;
import com.study.springboot.member.entity.Member;
import com.study.springboot.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    
    private final MemberRepository memberRepository;
    
    @Transactional
    public MemberResponse signup(MemberSignupRequest request) {
        // 이메일 중복 체크
        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }
        
        // 닉네임 중복 체크
        if (memberRepository.existsByNickname(request.getNickname())) {
            throw new RuntimeException("이미 존재하는 닉네임입니다.");
        }
        
        Member member = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword()) // TODO: 비밀번호 암호화 필요
                .nickname(request.getNickname())
                .role(Member.Role.USER)
                .build();
        
        Member savedMember = memberRepository.save(member);
        return MemberResponse.from(savedMember);
    }
    
    public MemberResponse login(MemberLoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 이메일입니다."));
        
        if (!member.getPassword().equals(request.getPassword())) { // TODO: 비밀번호 암호화 비교 필요
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        
        return MemberResponse.from(member);
    }
    
    public MemberResponse getMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
        
        return MemberResponse.from(member);
    }
    
    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public MemberResponse updateProfile(Long memberId, String nickname, String profileImage) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
        
        if (nickname != null && !nickname.equals(member.getNickname())) {
            if (memberRepository.existsByNickname(nickname)) {
                throw new RuntimeException("이미 존재하는 닉네임입니다.");
            }
            member.setNickname(nickname);
        }
        
        if (profileImage != null) {
            member.setProfileImage(profileImage);
        }
        
        return MemberResponse.from(member);
    }
} 