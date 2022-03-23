package com.management.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findStudentByTeacherId(int teacherId);
	List<Student> findStudentByName(String studentName);
}
