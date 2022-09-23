package com.java.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
