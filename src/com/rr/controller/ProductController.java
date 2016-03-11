package com.rr.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

import com.rr.domain.Product;
import com.rr.repository.ProductRepository;
import com.rr.service.ProductService;


@Controller
@RequestMapping("products")
public class ProductController {

	//@Autowired
	//ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	
	
	
	/*@RequestMapping("/product")
	public String list(Model model)
	{
		
		Product pd = new Product("123", "Iphone 5S", new BigDecimal(500000), "Iphone 5s", "Apple", "Mobile",5000l, 100l, true, "Paytm copun");
		model.addAttribute("product", pd);
		return "product";
	}*/
	
	@RequestMapping
	public String list(Model model)
	{
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("product") //GET parameters example
	public String getProductById(@RequestParam("id") String productId,Model model)
	{
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	@RequestMapping("/all") 
	public ModelAndView allProducts()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products",productService.getAllProducts());
		//Product pd = new Product("123", "Iphone 5S", new BigDecimal(500000), "Iphone 5s", "Apple", "Mobile",5000l, 100l, true, "Paytm copun");
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	@RequestMapping("/{category}") // path variables example
	public String getProductsByCategory(Model model,@PathVariable("category") String category)
	{
		model.addAttribute("products", productService.getProductsByCategory(category));
		return "products";
	}
	
	/*
	 * @RequestMapping("/filter/{ByCriteria}/{BySpecification}")
	 * http://localhost:8080/webstore/products/filter/ByCriteria;brand=google,dell;category=tablet,laptop/BySpecification;dimention=10,20,15;color=red,green,blue
	 */
	
	// http://localhost:8080/OnlineShop/products/filter/ByCriteria;brand=google,dell;category=tablet,laptop
	@RequestMapping("/filter/{ByCriteria}") // matrix variables example
	public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,Model model)
	{
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	//http://localhost:8080/webstore/products/tablet/price;low=200;high=400?manufacturer="Google"
	@RequestMapping("/{category}/{price}")
	public String filterProducts(@PathVariable("category") String category, @MatrixVariable(pathVar = "price") Map<String, List<String>> price,@RequestParam("manufacturer") String manufacturer)
	{
		return null;
		// TODO : Need to implement this services.
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getAddNewProducatForm(Model model)
	{
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId","name","unitPrice","description","manufacturer","category","unitsInStock", "condition","productImage");
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, ModelMap map, BindingResult result, HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		MultipartFile productImage = productToBeAdded.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
				
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
		      	productImage.transferTo(new File(rootDirectory+"resources\\images\\"+productToBeAdded.getProductId() + ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }

				productService.addProduct(productToBeAdded);
		return "redirect:/products"; // This pattern is calledRedirect After Post,
	}
	
}
