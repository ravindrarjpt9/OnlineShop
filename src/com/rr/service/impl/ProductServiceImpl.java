package com.rr.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rr.domain.Product;
import com.rr.repository.ProductRepository;
import com.rr.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(String pId) {
		return productRepository.getProductById(pId);
	}
	
	@Override
	public List<Product> getProductsByCategory(String name) {
		
		return productRepository.getProductByCategory(name);
	}
	
	@Override
	public Set<Product> getProductsByFilter(
			Map<String, List<String>> filterParams) {
		
		return productRepository.getProductsByFilter(filterParams);
	}
	
	@Override
	public Set<Product> getProductsByManufacturer(String manufacturer) {

		return productRepository.getProductsByManufacturer(manufacturer);
	}
	
	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
		
	}

}
