package com.rr.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rr.domain.Product;

public interface ProductRepository {
	List <Product> getAllProducts();
	Product getProductById(String pId);
	
	List<Product> getProductByCategory(String categoryName);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	
	Set<Product> getProductsByManufacturer(String manufacturer);
	
	void addProduct(Product product);
}
