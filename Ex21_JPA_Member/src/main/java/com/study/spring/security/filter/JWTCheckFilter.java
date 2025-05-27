package com.study.spring.security.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.study.spring.dto.MemberDto;
import com.study.spring.util.CustomJWTException;
import com.study.spring.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class JWTCheckFilter extends OncePerRequestFilter {

	
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		//true == not cheking
		String path = request.getRequestURI();
	    log.info("check uri.............." + path);
	    
	    //api/member/ 경로의 호출은 체크하지 않음 
	    if(path.startsWith("/api/member/")) {
	      return true;
	    } 
		
	    
	    // false == check
		return false;
	}

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, 
//			HttpServletResponse response, 
//			FilterChain filterChain)
//			throws ServletException, IOException {
//		
//		log.info("-----------------------------");
//		log.info("-----------------------------");
//		log.info("-----------------------------");
//
//		String authHeaderStr = request.getHeader("Authorization");
//		
//		String accessToken = authHeaderStr.substring(7);
//		Map<String, Object> claims = JWTUtil.validateToken(accessToken);
//		log.info(claims);
//			
//	
//		
//		filterChain.doFilter(request, response);
//		
//	}
	
	@Override
	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

	    log.info("------------------------JWTCheckFilter.......................");

	    String authHeaderStr = request.getHeader("Authorization");

	    try {
	      //Bearer accestoken...
	      String accessToken = authHeaderStr.substring(7);
	      Map<String, Object> claims = JWTUtil.validateToken(accessToken);

	      log.info("JWT claims: " + claims);

	      //filterChain.doFilter(request, response); //이하 추가 

	      String email = (String) claims.get("email");
	      String password = (String) claims.get("password");
	      String nickname = (String) claims.get("nickname");
	      Boolean social = (Boolean) claims.get("social");
	      List<String> roleNames = (List<String>) claims.get("roleNames");

	      MemberDto memberDto = new MemberDto(email, password, nickname, social.booleanValue(), roleNames);

	      log.info("-----------------------------------");
	      log.info(memberDto);
	      log.info(memberDto.getAuthorities());

	      UsernamePasswordAuthenticationToken authenticationToken
	      = new UsernamePasswordAuthenticationToken(memberDto, password, memberDto.getAuthorities());

	      SecurityContextHolder.getContext().setAuthentication(authenticationToken);

	      filterChain.doFilter(request, response);

	    }catch(Exception e){

	      log.error("JWT Check Error..............");
	      log.error(e.getMessage());

	      Gson gson = new Gson();
	      String msg = gson.toJson(Map.of("error", "ERROR_ACCESS_TOKEN1"));

	      response.setContentType("application/json");
	      PrintWriter printWriter = response.getWriter();
	      printWriter.println(msg);
	      printWriter.close();

	    }
	  }

	
}
