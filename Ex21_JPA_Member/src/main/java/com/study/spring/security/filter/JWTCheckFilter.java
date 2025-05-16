package com.study.spring.security.filter;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.filter.OncePerRequestFilter;

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
		
	    
	    // false == check
		return false;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		
		log.info("-----------------------------");
		log.info("-----------------------------");
		log.info("-----------------------------");

		String authHeaderStr = request.getHeader("Authorization");
		
		String accessToken = authHeaderStr.substring(7);
		Map<String, Object> claims;
		
		
			try {
				claims = JWTUtil.validateToken(accessToken);
				log.info(claims);
			} catch (CustomJWTException e) {
				e.printStackTrace();
				log.info("---------토큰이 에러난것 같음------------");
			}
		

			
	
		
		
		
		filterChain.doFilter(request, response);
		
		
		
	}

	
}
