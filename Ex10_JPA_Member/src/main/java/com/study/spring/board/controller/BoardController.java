package com.study.spring.board.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bbs")
@EnableMethodSecurity
public class BoardController {

	@GetMapping("/")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_MANAGER','ROLE_ADMIN')")
	public String bbsList() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "view - User: " + auth.getName() + ", Authorities: " + auth.getAuthorities();
	}
	
	@GetMapping("/about")
	public String test() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "about - User: " + auth.getName() + ", Authorities: " + auth.getAuthorities();
	}
	
	@GetMapping("/his")
	@PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
	public String comp() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "his - User: " + auth.getName() + ", Authorities: " + auth.getAuthorities();
	}
}
