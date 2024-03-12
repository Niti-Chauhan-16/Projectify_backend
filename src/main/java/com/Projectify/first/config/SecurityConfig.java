package com.Projectify.first.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Projectify.first.service.UserInfoService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	UserInfoService userInfoService;
	
	@Autowired
	public void setUserService(UserInfoService userInfoService) {
		this.userInfoService=userInfoService;
	}
	
	 @Bean
	 public UserDetailsService userDetailsService() {
	        return userInfoService;
	 }

	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userInfoService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.csrf((csrf)->csrf.disable())
		       .authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated());
		http.formLogin((form)->form.disable());
		http.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	

}
