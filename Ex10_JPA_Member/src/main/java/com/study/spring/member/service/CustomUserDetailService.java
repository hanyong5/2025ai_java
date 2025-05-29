package com.study.spring.member.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.spring.member.entity.Member;
import com.study.spring.member.repository.MemberRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("**************load user by username *********************"+ username);
		
		Optional<Member> member = memberRepository.findByEmail(username);
		
		log.info("----> "+member+" <----");
		
		return null;
	}

}
