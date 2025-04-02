package com.study.spring.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		System.out.println("----------------------filter chain---------------------------");
		
		
		http.csrf((csrf)-> csrf.disable())
			.cors((cors)->cors.disable())
			.authorizeHttpRequests((request)->request
					.requestMatchers("/writeForm","/write").hasRole("ADMIN")
					.requestMatchers("/login").permitAll()
					.anyRequest().permitAll()
					);

        http.formLogin(formLogin -> formLogin
            .loginPage("/login")
            .permitAll()
        );
        
        http.logout(logout->logout.logoutSuccessUrl("/"));


    return http.build();
    }
}
