package com.example.springcache.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springcache.domain.Student;

@Service
public class StudentService {
	private List<Student> studentList = new ArrayList<Student>(
				Arrays.asList(
					new Student("1", "ram", "20"),
					new Student("2", "arun", "21"), 
					new Student("3", "karthick", "22"), 
					new Student("4", "Kapil", "30")
					)
				);

	public void createStudent(Student student) {
		studentList.add(student);
	}

	public List<Student> getAllStudents() {
		try {
			System.out.println("Going to sleep for 10 Secs.. to simulate backend call.");
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Cacheable (value = "students", key = "#id")
	public Student getStudentById(String id) {
		try {
			System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return studentList.stream().filter(student -> student.getId().equals(id)).findFirst().get();
	}

    // both execute the method as well as cache the results each and every time:
    // update the content of the cache without interfering with the method execution.
    @CachePut(value = "students", key = "#id")
	public void updateStudent(String id, Student student) {
		int counter = 0;
		for (Student eachStudent : studentList) {
			if (eachStudent.getId().equals(id)) {
				studentList.set(counter, student);
			}
			counter++;
		}
	}
// @CacheEvict annotation to indicate the removal of one or more/all values so that fresh values can be loaded into the cache again:
  // removing stale and unused entries,
    @CacheEvict(value = "students", allEntries = true)
	public void deleteStudentById(String id) {
		studentList.removeIf(student -> student.getId().equals(id));
	}
}
