package com.sbms.service;

import java.util.List;

import com.sbms.dto.CustomerDto;
import com.sbms.entity.Customer;
import com.sbms.entity.UserInfo;


public interface CustomerService {
	Long saveCustomer(CustomerDto customerDto);
	Customer getCustomer(Long id);
	List<Customer> getAllCustomers();
	
}
