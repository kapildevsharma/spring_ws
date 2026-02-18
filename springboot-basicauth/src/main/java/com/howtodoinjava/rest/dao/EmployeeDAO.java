package com.howtodoinjava.rest.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@Repository
public class EmployeeDAO 
{
    private static Employees list = new Employees();
    
    static 
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
    }
    
    public Employees getAllEmployees() 
    {
        return list;
    }
    
    public Employee getEmployeeById(Integer id) 
    {
    	Optional<Employee> matchingObject  = list.getEmployeeList().stream().filter(e -> e.getId()==id).findFirst();
    	Employee employee = matchingObject.orElse(null);
    	return employee;
    }
    
    public void deletetEmployeeById(Integer id) 
    {
    	List<Employee> employeeList = list.getEmployeeList().stream().filter(e -> e.getId()!=id).collect(Collectors.toList());
    	list.getEmployeeList().clear();
    	list.getEmployeeList().addAll(employeeList);
    }
    
    public boolean existsEmployeeById(Integer id) 
    {
    	Optional<Employee> matchingObject  = list.getEmployeeList().stream().filter(e -> e.getId()==id).findFirst();
    	Employee employee = matchingObject.orElse(null);
    	return employee==null?false:true;
    }
    
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
