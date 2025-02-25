package com.sbms.dto;

import com.sbms.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private String name;
	private String email;
	private String mobileNo;
	private Address address;
}
