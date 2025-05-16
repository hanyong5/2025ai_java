package com.study.spring.security;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysql.cj.log.Log;
import com.study.spring.dto.MemberDto;
import com.study.spring.entity.Member;
import com.study.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
//@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberRepository memberRepository;

	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("-----------------loadUserByUsername-------------------");
		
		Optional<Member> member = memberRepository.findByEmail(username);
		
//		System.out.println(member.toString());
//		 if(member == null){
//		      throw new UsernameNotFoundException("Not Found");
//		    }
		
		if(!member.isPresent()){
		      throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
		}

			System.out.println("정확한 정보임"+ member.toString());
		    MemberDto memberDto = new MemberDto(
		    		member.get().getEmail(),
			        member.get().getPassword(),
			        member.get().getNickname(),
			        member.get().isSocial(),
			        member.get().getMemberRoleList()
			            .stream()
			            .map(memberRole -> memberRole.name())
			            .collect(Collectors.toList())
		    		);

//		    System.out.println(memberDto.toString());
		
//		 MemberDto memberDto = new MemberDto(
//				 
//		            member.getEmail(),
//		            member.getPw(),
//		            member.getNickname(),
//		            member.isSocial(),
//		            member.getMemberRoleList()
//		                  .stream()
//		                  .map(memberRole -> memberRole.name()).collect(Collectors.toList()));
//


//		 System.out.println(memberDto.toString());
		 log.info(memberDto);

		    return memberDto;
	}
	
	
	
	
}
