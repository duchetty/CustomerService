package com.sbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbms.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
