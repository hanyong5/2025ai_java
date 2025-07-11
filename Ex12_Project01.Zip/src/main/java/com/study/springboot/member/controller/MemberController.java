package com.study.springboot.member.controller;

import com.study.springboot.member.dto.MemberLoginRequest;
import com.study.springboot.member.dto.MemberResponse;
import com.study.springboot.member.dto.MemberSignupRequest;
import com.study.springboot.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;
    
    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> signup(@RequestBody MemberSignupRequest request) {
        MemberResponse response = memberService.signup(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/login")
    public ResponseEntity<MemberResponse> login(@RequestBody MemberLoginRequest request) {
        MemberResponse response = memberService.login(request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable(name = "memberId") Long memberId) {
        MemberResponse response = memberService.getMember(memberId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> responses = memberService.getAllMembers();
        return ResponseEntity.ok(responses);
    }
    
    @PutMapping("/{memberId}/profile")
    public ResponseEntity<MemberResponse> updateProfile(
            @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "nickname", required = false) String nickname,
            @RequestParam(name = "profileImage", required = false) String profileImage) {
        MemberResponse response = memberService.updateProfile(memberId, nickname, profileImage);
        return ResponseEntity.ok(response);
    }
} 