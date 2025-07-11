package com.study.spring.member.dto;

import com.study.spring.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MemberResponse {
    
    private Long id;
    private String email;
    private String nickname;
    private String gender;
    private String profileImageUrl;
    private LocalDateTime createdAt;
    
    public static MemberResponse from(Member member) {
        MemberResponse response = new MemberResponse();
        response.setId(member.getId());
        response.setEmail(member.getEmail());
        response.setNickname(member.getNickname());
        response.setGender(member.getGender().getName());
        response.setProfileImageUrl(member.getProfileImageUrl());
        response.setCreatedAt(member.getCreatedAt());
        return response;
    }
} 