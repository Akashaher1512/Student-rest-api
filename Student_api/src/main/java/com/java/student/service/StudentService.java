package com.java.student.service;

import java.util.List;

import com.java.student.entity.Student;

public interface StudentService {

	//add student
    public	Student createStudent(Student student);
	
	//update student
	Student updateStudent(Student student, Integer studentId);
	
	//get all student 
	List<Student> getStudents();
	
	//get student by id
	Student getStudentById(Integer studentId);
	
	//delete student
	void deleteStudent(Integer studentID);
	
}
