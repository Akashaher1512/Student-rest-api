package com.java.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.student.entity.Student;
import com.java.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
//create student controller
	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		//service
		Student createStudent = this.studentService.createStudent(student);
		
		return new ResponseEntity<Student>(createStudent, HttpStatus.CREATED);
	}
	
}
