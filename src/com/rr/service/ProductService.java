package com.rr.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rr.domain.Product;

public interface ProductService {

	
	List<Product> getAllProducts();
	Product getProductById(String pId);
	
	List<Product> getProductsByCategory(String name);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	Set<Product> getProductsByManufacturer(String manufacturer);
	
	void addProduct(Product product);
}
