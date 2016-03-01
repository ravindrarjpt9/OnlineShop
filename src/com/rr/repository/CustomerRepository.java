package com.rr.repository;

import java.util.List;

import com.rr.domain.Customer;

public interface CustomerRepository {

	List<Customer> getAllCustomers();
}
