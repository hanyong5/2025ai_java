package com.study.springboot.member.dto;

import com.study.springboot.member.entity.Member;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberResponse {
    
    private Long id;
    private String email;
    private String nickname;
    private String profileImage;
    private String role;
    private LocalDateTime createdAt;
    
    public static MemberResponse from(Member member) {
        MemberResponse response = new MemberResponse();
        response.setId(member.getId());
        response.setEmail(member.getEmail());
        response.setNickname(member.getNickname());
        response.setProfileImage(member.getProfileImage());
        response.setRole(member.getRole().name());
        response.setCreatedAt(member.getCreatedAt());
        return response;
    }
} 