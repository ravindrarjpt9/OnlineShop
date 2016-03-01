package com.rr.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rr.domain.Customer;
import com.rr.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private List<Customer> custList = new ArrayList<Customer>();
	public CustomerRepositoryImpl() {
		custList.add(new Customer("c101", "Ravi","Delhi", 1));
		custList.add(new Customer("c102", "Shalu","Delhi", 3));
		custList.add(new Customer("c103", "Test","Delhi", 3));
		custList.add(new Customer("c104", "Ram","Delhi", 4));
		
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return custList;
	}

}
