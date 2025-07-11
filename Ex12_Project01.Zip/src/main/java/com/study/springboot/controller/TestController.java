package com.study.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/test")
    public String test() {
        return "맛집사이트 API가 정상적으로 작동합니다!";
    }
    
    @GetMapping("/")
    public String home() {
        return "맛집사이트 API 서버입니다.";
    }
} 