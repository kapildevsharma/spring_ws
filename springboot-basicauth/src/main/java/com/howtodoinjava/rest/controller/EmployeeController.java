package com.howtodoinjava.rest.controller;

import java.net.URI;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.howtodoinjava.rest.dao.EmployeeDAO;
import com.howtodoinjava.rest.exception.CustomException;
import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDao;

	@GetMapping(path = "/", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public Employees getEmployees() {
		return employeeDao.getAllEmployees();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public Employee getEmployeeById(@PathParam("id") Integer id) {
		return employeeDao.getEmployeeById(id);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	public void deletetEmployees(@PathVariable Integer id) throws Exception {
		if (employeeDao.existsEmployeeById(id)) {
			employeeDao.deletetEmployeeById(id);
		} else {
			throw new CustomException(Employee.class + "id" + id);
		}
	}

	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(
			@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
			@RequestHeader(name = "X-COM-LOCATION", defaultValue = "ASIA") String headerLocation,
			@RequestBody Employee employee) throws Exception {
		// Generate resource id
		Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
		employee.setId(id);

		// add resource
		employeeDao.addEmployee(employee);

		// Create resource location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();

		// Send location in response
		return ResponseEntity.created(location).build();
	}
}
