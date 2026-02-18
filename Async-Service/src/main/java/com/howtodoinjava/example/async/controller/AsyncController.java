package com.howtodoinjava.example.async.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.example.async.model.EmployeeAddresses;
import com.howtodoinjava.example.async.model.EmployeeNames;
import com.howtodoinjava.example.async.model.EmployeePhone;
import com.howtodoinjava.example.async.service.AsyncService;

@RestController
public class AsyncController {

	private static Logger log = LoggerFactory.getLogger(AsyncController.class);

	@Autowired
	private AsyncService service;

	@RequestMapping(value = "/testAsynch", method = RequestMethod.GET)
	public void testAsynch() throws InterruptedException, ExecutionException 
	{
		log.info("testAsynch Start");

		CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
		CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();
		CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();

		
		// Wait until they are all done
		CompletableFuture.allOf(employeeAddress, employeeName, employeePhone).join();
		
		log.info("EmployeeAddress--> " + employeeAddress.get());
		log.info("EmployeeName--> " + employeeName.get());
		log.info("EmployeePhone--> " + employeePhone.get());
		
		String combined = Stream.of(employeeAddress, employeeName, employeePhone)
				  .map(CompletableFuture::join)
				  .map(Object::toString)
				  .collect(Collectors.joining(" "));
		log.info("combined --> " + combined);

		
		CompletableFuture<String> completableFuture
		  = CompletableFuture.supplyAsync(() -> "Hello");
		log.info("EmployeeAddress--> " + completableFuture.get());

		CompletableFuture<String> future = completableFuture
				.thenApply(s -> s + " World");
		log.info("EmployeeAddress--> " + future.get());
		
		log.info("EmployeeAddress--> " + future.get());
		CompletableFuture<Void> future1 = future
				  .thenAccept(s -> System.out.println("Computation returned: " + s))
				  .thenRun(() -> System.out.println("Computation finished"));

		log.info("EmployeeAddress--> " + future1.get());
		
		CompletableFuture<String> future2 = completableFuture
				.thenApply(s -> s + " Good Morning");
		CompletableFuture<String> combinedFuture 
        = future.thenCombine( 
        		future2, (m1, m2) -> m1 + " " + m2); 

		System.out.println(combinedFuture.get()); 
		
		CompletableFuture<Integer> resultFuture 
          = CompletableFuture.supplyAsync(() -> 10 / 0)   
                    .exceptionally(ex -> 0); 
      
        // 0 - returned by exceptionally block 
		System.out.println(resultFuture.get()); 
		

	}
}
