package com.rr.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rr.domain.Product;
import com.rr.repository.ProductRepository;


@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	
	
	/*@RequestMapping("/product")
	public String list(Model model)
	{
		
		Product pd = new Product("123", "Iphone 5S", new BigDecimal(500000), "Iphone 5s", "Apple", "Mobile",5000l, 100l, true, "Paytm copun");
		model.addAttribute("product", pd);
		return "product";
	}*/
	
	
	@RequestMapping("/products")
	public String list(Model model)
	{
		
		//Product pd = new Product("123", "Iphone 5S", new BigDecimal(500000), "Iphone 5s", "Apple", "Mobile",5000l, 100l, true, "Paytm copun");
		model.addAttribute("products", productRepository.getAllProducts());
		return "products";
	}
}
