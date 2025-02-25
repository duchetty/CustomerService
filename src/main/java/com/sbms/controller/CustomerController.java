package com.sbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.dto.CustomerDto;
import com.sbms.entity.Customer;
import com.sbms.entity.UserInfo;
import com.sbms.service.CustomerService;
import com.sbms.service.UserInfoService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private UserInfoService userInfoService;
	@PostMapping("/user/save")
	public String fetchCustomer(@RequestBody UserInfo userInfo)
	{
		userInfoService.saveUser(userInfo);
		return "User save Successfully";
	}
	
	@PostMapping("/save")
	public ResponseEntity<Long> fetchCustomer(@RequestBody CustomerDto courseDto)
	{
		Long courseId=customerservice.saveCustomer(courseDto);
		return new ResponseEntity<>(courseId,HttpStatus.CREATED);
	}
	@GetMapping("/get/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id)
	{
		Customer customer=customerservice.getCustomer(id);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomers")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Customer> getAllCustomers()
	{
		return customerservice.getAllCustomers();
	}
	
}
