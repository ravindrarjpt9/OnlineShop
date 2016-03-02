package com.rr.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.rr.domain.Product;
import com.rr.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {

		Product pd = new Product("P1234", "Iphone 5S", new BigDecimal(500000), "Iphone 5s", "Apple", "Mobile",5000l, 100l, true, "Paytm copun");
		Product pd1 = new Product("123", "Ipod", new BigDecimal(500000), "Ipad Mini", "Apple", "Tablet",5000l, 100l, true, "Paytm copun");

		Product pd2 = new Product("122", "Nexus 5", new BigDecimal(500000), "Googel Nexus 5", "Googel", "Mobile",5000l, 100l, true, "Paytm copun");

		Product pd3 = new Product("121", "Sony X-P", new BigDecimal(500000), "Sony X-Perya", "Sony", "Tablet",5000l, 100l, true, "Paytm copun");

		Product pd4 = new Product("120", "ZOLO", new BigDecimal(500000), "ZOLO Mobile", "ZOLO", "Mobile",5000l, 100l, true, "Snapdeal copun");

		
		listOfProducts.add(pd);
		listOfProducts.add(pd1);
		listOfProducts.add(pd2);
		listOfProducts.add(pd3);
		listOfProducts.add(pd4);
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
	
	@Override
	public List<Product> getProductByCategory(String categoryName) {
		List<Product> list = new ArrayList<Product>();
		
		for(Product p : listOfProducts)
		{
			if(p.getCategory().equalsIgnoreCase(categoryName))
			{
				list.add(p);
			}
		}
		return list;
	}
	
	@Override
	public Set<Product> getProductsByFilter(
			Map<String, List<String>> filterParams) {
		Set<Product> productByBrand = new HashSet<Product>();
		Set<Product> productByCategory = new HashSet<Product>();
		
		Set<String> criterias = filterParams.keySet();
		
		if(criterias.contains("brand"))
		{
			for(String b : filterParams.get("brand"))
			{
				for(Product p : listOfProducts)
				{
					if(p.getManufacturer().equalsIgnoreCase(b))
					{
						productByBrand.add(p);
					}
				}
			}
		}
		if(criterias.contains("category"))
		{
			for(String c : filterParams.get("category"))
			{
				productByCategory.addAll(this.getProductByCategory(c));
			}
		}
		productByCategory.retainAll(productByBrand);
		return productByCategory;
	}
	
	@Override
	public Set<Product> getProductsByManufacturer(String manufacturer) {
		Set<Product> producatList = new HashSet<Product>();
		for(Product p : listOfProducts)
		{
			if(p.getManufacturer().equalsIgnoreCase(manufacturer))
			{
				producatList.add(p);
			}
		}
		return producatList;
	}
	
	@Override
	public void addProduct(Product product) {
		
		listOfProducts.add(product);
	}
	
}
