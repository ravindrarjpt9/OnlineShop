package com.rr.repository;

import java.util.List;

import com.rr.domain.Product;

public interface ProductRepository {
	List <Product> getAllProducts();
	Product getProductById(String pId);
}
