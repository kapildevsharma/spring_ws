package com.example.springcache.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcache.domain.Student;
import com.example.springcache.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentService service;

	private AtomicInteger count = new AtomicInteger();
	static long count1 = 0;
	
	@PostMapping("/create")
	public void create(@Valid @RequestBody Student student) {
		service.createStudent(student);
	}

	@GetMapping("/getAll")
	public List<Student> get() {
		count.incrementAndGet();
		count1++;

		System.out.println("AtomicInteger coount ::"+this.count.get());
		
		System.out.println("static count ::"+count);
		System.out.println("Searching All Students");
		return service.getAllStudents();
	}

	@GetMapping("/get/{id}")
	public Student getById(@PathVariable("id") String id) {
		System.out.println("Searching by ID  : " + id);
		return service.getStudentById(id);
	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable("id") String id, @Valid @RequestBody Student student) {
		service.updateStudent(id, student);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") String id) {
		this.service.deleteStudentById(id);
	}
}
