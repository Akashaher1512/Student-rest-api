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
		student1.setCity(student.getCity());
		student1.setPhone(student.getPhone());
		
		Student updatedStudent = this.studentRepo.save(student1);
		
		return updatedStudent;
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentById(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(Integer studentID) {
		// TODO Auto-generated method stub
		
	}

}
