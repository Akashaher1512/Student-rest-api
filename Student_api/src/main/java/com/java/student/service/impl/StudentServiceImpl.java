package com.java.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.student.entity.Student;
import com.java.student.repository.StudentRepo;
import com.java.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Student createStudent(Student student) {

		Student savedStudent = this.studentRepo.save(student);
		return savedStudent;
	}

	@Override
	public Student updateStudent(Student student, Integer studentId) {
		
		Student student1 = this.studentRepo.findById(studentId).orElseThrow(null);
		student1.setName(student.getName());
		student1.setPhone(student.getPhone());
		student1.setCity(student.getCity());
		
		Student savedStudent = this.studentRepo.save(student1);
		return savedStudent;	
	}

	@Override
	public List<Student> getStudents() {
		List<Student> students = this.studentRepo.findAll();
		return students;
	}

	@Override
	public Student getStudentById(Integer studentId) {
		Student student = this.studentRepo.findById(studentId).orElseThrow(null);
		
		return student;
		
	}

	@Override
	public void deleteStudent(Integer studentID) {
		Student student = this.studentRepo.findById(studentID).orElseThrow(null);
		this.studentRepo.delete(student);
	}

}
