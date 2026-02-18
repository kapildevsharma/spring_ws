package com.javasampleapproach.jackson.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jackson.model.Company;
import com.javasampleapproach.jackson.model.Product;

@RestController
public class WebController {

	private Company apple;
	private Product iphone7;
	private Product iPadPro;
	
	@PostConstruct
	public void initial(){
		iphone7 = new Product(1, "Iphone 7");
        iPadPro = new Product(2, "IPadPro");
        
        List<Product> appleProducts = new ArrayList<Product>(Arrays.asList(iphone7, iPadPro));
        
        apple = new Company(1, "Apple", appleProducts);
        
        iphone7.setCompany(apple);
        iPadPro.setCompany(apple);
	}
	
	/*
	 * URLs MAKE ERRORS {'/company', '/product'}
	 */
	@GetMapping("/company")
	public Company getCompany(){
		return apple; 
	}
	
	@GetMapping("/product")
	public Product getProduct(){
		return iphone7; 
	}
	
}
