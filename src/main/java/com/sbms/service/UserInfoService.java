package com.sbms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sbms.entity.UserInfo;
import com.sbms.repository.UserInfoRespository;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoRespository userInfoRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	public UserInfo saveUser(UserInfo userInfo)
	{
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		return userInfoRepository.save(userInfo);
	}
}
