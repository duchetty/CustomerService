package com.sbms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.sbms.service.UserInfoUserDetailsSerivce;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity 
public class SecurityConfig {

		@Bean
		public UserDetailsService userDetailsSerive()
		{
			return new UserInfoUserDetailsSerivce();
		}
		
		@Bean
		public PasswordEncoder passwordEncoder()
		{
			return new BCryptPasswordEncoder();
		}
		
		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
		{
			return http.csrf().disable().authorizeHttpRequests()
										.requestMatchers("/customer/save","customer/user/save")
										.permitAll()
										.and()
										.authorizeHttpRequests()
										.requestMatchers("/customer/**")
										.authenticated()
										.and()
										.formLogin()
										.and()
										.logout().and().build();
		}
		
		@Bean
		public AuthenticationProvider authenticationProvider( )
		{
			DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
			provider.setUserDetailsService(userDetailsSerive());
			provider.setPasswordEncoder(passwordEncoder());
			return provider;
		}
		
}
