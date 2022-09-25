package com.java.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//update student
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student  student,@PathVariable  Integer id){
		
		Student updateStudent = this.studentService.updateStudent(student, id);
		
		return new ResponseEntity<Student>(updateStudent, HttpStatus.OK);
	}
	
//get student by id 
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getbyId(@PathVariable Integer id){
		Student student = this.studentService.getStudentById(id);
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

//get students
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		List<Student> students = this.studentService.getStudents();
		
		return students;
	}
		
//delete student	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		this.studentService.deleteStudent(id);
		return "Student Deleted Successfully"; 
	}
	
	
}







