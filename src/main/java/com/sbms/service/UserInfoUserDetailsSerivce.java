package com.sbms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sbms.entity.UserInfo;
import com.sbms.repository.UserInfoRespository;

@Component
public class UserInfoUserDetailsSerivce implements UserDetailsService {

	@Autowired
	private UserInfoRespository userInfoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		UserInfo userInfo=userInfoRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
		
		
		return User.builder().username(userInfo.getUsername()).password(userInfo.getPassword()).roles(userInfo.getRoles().split(",")).build();
	}

}
