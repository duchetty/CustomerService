package com.sbms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbms.entity.Customer;
import com.sbms.entity.UserInfo;

public interface UserInfoRespository extends JpaRepository<UserInfo,Long>{
		Optional<UserInfo> findByUsername(String username);
}
