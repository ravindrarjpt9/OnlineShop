package com.rr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rr.domain.Customer;
import com.rr.repository.CustomerRepository;
import com.rr.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.getAllCustomers();
	}

}
