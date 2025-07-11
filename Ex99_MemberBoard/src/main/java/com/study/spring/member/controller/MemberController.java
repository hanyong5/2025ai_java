package com.study.spring.member.controller;

import com.study.spring.member.dto.ApiResponse;
import com.study.spring.member.dto.MemberLoginRequest;
import com.study.spring.member.dto.MemberResponse;
import com.study.spring.member.dto.MemberSignupRequest;
import com.study.spring.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;
    
    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<MemberResponse>> signup(@Valid @RequestBody MemberSignupRequest request) {
//    	{
//    	    "email": "hanyong5@naver.com",
//    	    "password": "!Han1234",
//    	    "nickname": "테스트",
//    	    "gender": "남성"
//    	  }        
    	
    	try {
            log.info("회원가입 요청 받음: {}", request.getEmail());
            
            MemberResponse memberResponse = memberService.signup(request);
            
            return ResponseEntity.ok(ApiResponse.success("회원가입이 완료되었습니다.", memberResponse));
            
        } catch (IllegalArgumentException e) {
            log.warn("회원가입 실패: {}", e.getMessage());
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
            
        } catch (Exception e) {
            log.error("회원가입 중 오류 발생: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("회원가입 중 오류가 발생했습니다."));
        }
    }
    
    /**
     * 로그인
     */
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<MemberResponse>> login(@Valid @RequestBody MemberLoginRequest request) {
        try {
            log.info("로그인 요청 받음: {}", request.getEmail());
            
            MemberResponse memberResponse = memberService.login(request);
            
            return ResponseEntity.ok(ApiResponse.success("로그인이 완료되었습니다.", memberResponse));
            
        } catch (IllegalArgumentException e) {
            log.warn("로그인 실패: {}", e.getMessage());
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
            
        } catch (Exception e) {
            log.error("로그인 중 오류 발생: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("로그인 중 오류가 발생했습니다."));
        }
    }
    
    /**
     * 이메일 중복 확인
     */
    @GetMapping("/check-email")
    public ResponseEntity<ApiResponse<Map<String, Boolean>>> checkEmailDuplicate(@RequestParam("email") String email) {
        try {
            log.info("이메일 중복 확인 요청: {}", email);
            
            boolean isDuplicate = memberService.checkEmailDuplicate(email);
            Map<String, Boolean> result = new HashMap<>();
            result.put("isDuplicate", isDuplicate);
            
            String message = isDuplicate ? "이미 사용 중인 이메일입니다." : "사용 가능한 이메일입니다.";
            
            return ResponseEntity.ok(ApiResponse.success(message, result));
            
        } catch (Exception e) {
            log.error("이메일 중복 확인 중 오류 발생: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("이메일 중복 확인 중 오류가 발생했습니다."));
        }
    }
    
    /**
     * 닉네임 중복 확인
     */
    @GetMapping("/check-nickname")
    public ResponseEntity<ApiResponse<Map<String, Boolean>>> checkNicknameDuplicate(@RequestParam("nickname") String nickname) {
        try {
            log.info("닉네임 중복 확인 요청: {}", nickname);
            
            boolean isDuplicate = memberService.checkNicknameDuplicate(nickname);
            Map<String, Boolean> result = new HashMap<>();
            result.put("isDuplicate", isDuplicate);
            
            String message = isDuplicate ? "이미 사용 중인 닉네임입니다." : "사용 가능한 닉네임입니다.";
            
            return ResponseEntity.ok(ApiResponse.success(message, result));
            
        } catch (Exception e) {
            log.error("닉네임 중복 확인 중 오류 발생: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("닉네임 중복 확인 중 오류가 발생했습니다."));
        }
    }
    
    /**
     * 회원 정보 조회
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponse>> getMemberInfo(@PathVariable("memberId")  Long memberId) {
        try {
            log.info("회원 정보 조회 요청: {}", memberId);
            
            MemberResponse memberResponse = memberService.getMemberInfo(memberId);
            
            return ResponseEntity.ok(ApiResponse.success("회원 정보 조회가 완료되었습니다.", memberResponse));
            
        } catch (IllegalArgumentException e) {
            log.warn("회원 정보 조회 실패: {}", e.getMessage());
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
            
        } catch (Exception e) {
            log.error("회원 정보 조회 중 오류 발생: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("회원 정보 조회 중 오류가 발생했습니다."));
        }
    }
    
    /**
     * 회원 목록 조회 (관리자용)
     */
    @GetMapping
    public ResponseEntity<ApiResponse<String>> getMemberList() {
        try {
            log.info("회원 목록 조회 요청");
            
            // TODO: 실제 회원 목록 조회 로직 구현
            // 현재는 간단한 메시지만 반환
            return ResponseEntity.ok(ApiResponse.success("회원 목록 조회 기능은 추후 구현 예정입니다.", ""));
            
        } catch (Exception e) {
            log.error("회원 목록 조회 중 오류 발생: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("회원 목록 조회 중 오류가 발생했습니다."));
        }
    }
} 