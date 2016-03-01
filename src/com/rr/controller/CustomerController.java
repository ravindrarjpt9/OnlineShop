package com.rr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rr.service.CustomerService;


@Controller
public class CustomerController {

	
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping("customerList")
	public String customerList(Model model)
	{
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
}
