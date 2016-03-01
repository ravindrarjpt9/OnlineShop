package com.rr.domain;

import java.math.BigInteger;

public class Customer {

	private String customerId;
	private String name;
	private String address;
	private int noOfOrdersMade;
	
	
	
	public Customer(String customerId, String name, String address,
			int noOfOrdersMade) {
		
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.noOfOrdersMade = noOfOrdersMade;
	}

	public Customer() {

		
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	public void setNoOfOrdersMade(int noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
	
	
}
