package com.rr.service;

import java.util.List;

import com.rr.domain.Product;

public interface ProductService {

	
	List <Product> getAllProducts();
	Product getProductById(String pId);
}
