package com.rr.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rr.domain.Product;
import com.rr.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {

		Product pd = new Product("P1234", "Iphone 5S", new BigDecimal(500000), "Iphone 5s", "Apple", "Mobile",5000l, 100l, true, "Paytm copun");
		Product pd1 = new Product("123", "Iphone 5S", new BigDecimal(500000), "Iphone 5s", "Apple", "Mobile",5000l, 100l, true, "Paytm copun");

		listOfProducts.add(pd);
		listOfProducts.add(pd1);
	}
	@Override
	public List<Product> getAllProducts() {
		
		
		return listOfProducts;

	}

	@Override
	public Product getProductById(String pId) {
		Product product = null;
		
		for(Product p : listOfProducts)
		{
			if(p != null && (p.getProductId().equalsIgnoreCase(pId)))
			{
				product = p;
				break;
			}
		}
		if(product == null)
		{
			throw new IllegalArgumentException("No products found with the product id: "+ pId);
		}
		return product;
	}
	
	
}
