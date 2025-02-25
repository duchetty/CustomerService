package com.sbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sbms.dto.CustomerDto;
import com.sbms.entity.Customer;
import com.sbms.exception.CustomerNotFoundException;
import com.sbms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Long saveCustomer(CustomerDto customerDto) {
		Customer customer=Customer.builder().name(customerDto.getName()).email(customerDto.getEmail()).mobileNo(customerDto.getMobileNo())
											.address(customerDto.getAddress()).build();
				customerRepository.save(customer);
		return customer.getId();
	}

	@Override
	public Customer getCustomer(Long id) {
		Customer Customer=customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer doesn't exist"));
		return Customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}
