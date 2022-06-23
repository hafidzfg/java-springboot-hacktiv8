package com.belajar.spring;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.belajar.spring.model.Course;
import com.belajar.spring.model.Student;
import com.belajar.spring.repository.CourseRepository;
import com.belajar.spring.repository.StudentRepository;

@SpringBootApplication
public class BelajarSpringStudent implements CommandLineRunner {
	
	private final Logger LOG = LoggerFactory.getLogger(BelajarSpringStudent.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringStudent.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception {
		// create a student
		Student student = new Student ("Hafidz Firmansyah", 24);
		
		// save the student
		studentRepository.save(student);
		
		// create 3 courses
		Course course1 = new Course("Fundamental of Springboot", 12, 1500);
		Course course2 = new Course("Object Oriented Programming", 8, 800);
		Course course3 = new Course("Structured Database", 9, 2000);
		
		// save the courses
		courseRepository.saveAll(Arrays.asList(course1, course2, course3));
		
		// add courses to the student
		student.getCourses().addAll(Arrays.asList(course1, course2, course3));
		
		// update the student
		studentRepository.save(student);
		
		
		List<Student> students = studentRepository.findAll();
		LOG.info("Students:"+students);
		
		List<Course> courses = courseRepository.findAll();
		LOG.info("Courses:"+courses);
	}

}
