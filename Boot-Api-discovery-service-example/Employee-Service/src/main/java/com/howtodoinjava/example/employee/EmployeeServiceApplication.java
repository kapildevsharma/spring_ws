package com.howtodoinjava.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient     // this registers the service to a discovery server with a name 
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
}

// before it, run the discovery server application to execute the eureka server. 
// http://127.0.0.1:8011/findEmployeeDetails/111