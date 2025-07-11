package com.study.springboot.member.dto;

import lombok.Data;

@Data
public class MemberSignupRequest {
    
    private String email;
    
    private String password;
    
    private String nickname;
} 