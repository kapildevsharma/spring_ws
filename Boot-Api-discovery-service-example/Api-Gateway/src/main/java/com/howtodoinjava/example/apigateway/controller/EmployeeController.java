package com.howtodoinjava.example.apigateway.controller;


import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class EmployeeController {

	@Autowired
	RestTemplate restTemplate;

	HttpHeaders createHeaders(String username, String password) {
		String auth = username + ":" + password;
		String base64Creds = Base64.getEncoder().encodeToString(auth.getBytes());
		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		return headers;
	}
	
	@GetMapping("/employeeDetails/{employeeid}")
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public String getStudents(@PathVariable int employeeid) {
		System.out.println("Getting Employee details for " + employeeid);

	 // create request with security
		/*
		 * HttpEntity<String> httpEntity = new
		 * HttpEntity<String>(createHeaders("username", "password")); String
		 * responseSecure = restTemplate.exchange(
		 * "http://employee-service/findEmployeeDetails/{employeeid}", HttpMethod.GET,
		 * httpEntity, new ParameterizedTypeReference<String>() { },
		 * employeeid).getBody();
		 */
	    
	    // add username and password in RestTemplate object
	  //  restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("username", "password"));
	    
		String response = restTemplate.exchange("http://employee-service/findEmployeeDetails/{employeeid}",
			HttpMethod.GET,null, new ParameterizedTypeReference<String>() {
			}, employeeid).getBody();

		System.out.println("Response Body " + response);

		return "Employee Id -  " + employeeid + " [ Employee Details " + response + " ]";
	}

	@GetMapping("/testMethod/{testStr}")
	@HystrixCommand(fallbackMethod = "myFallbackMethod")
	public String testMethod(@PathVariable String testStr) {
		System.out.println("Getting Employee details for " + testStr);

		String response = restTemplate.exchange("http://employee-service/getTestString/{employeeId}",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}, testStr).getBody();

		System.out.println("Response Body " + response);

		return "Employee Id -  " + testStr + " [ Employee Details " + response + " ]";
	}
	
	@GetMapping("/getStr")
	public String getStr() {
		return "Employee Id - TESt";
	}

	public String fallbackMethod(int employeeid) {
		return "Fallback response:: No employee details available temporarily";
	}

	public String myFallbackMethod(String myStr) {
		return "Fallback response:: No details available temporarily " + myStr;
	}

}
