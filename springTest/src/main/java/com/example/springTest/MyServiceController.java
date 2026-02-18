package com.example.springTest;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springTest.modal.Product;

@RestController
public class MyServiceController {

	private static final Logger logger = LogManager.getLogger(MyServiceController.class);

	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);

		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}

	@RequestMapping(value = "/")
	public String getName() {
		logger.debug("call default method");
		logger.info("logger info start");
		return "Service";
	}

	@GetMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	}

	@PostMapping(value = "/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productRepo.put(product.getId(), product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	// return boolean value
	/*
	 * @PostMapping (value = "/products", consumes = "application/json") public
	 * boolean createProduct(@RequestBody Product product) {
	 * productRepo.put(product.getId(), product); return true; }
	 */

	@PutMapping(value = "/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody Product product) {
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> delete(@PathVariable String id) {
		productRepo.remove(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@GetMapping(value = "/products/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable String id) {
		return new ResponseEntity<>(productRepo.get(id), HttpStatus.OK);
	}

}
