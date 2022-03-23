package com.management.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.student.dto.StudentDetails;
import com.management.student.entity.Student;
import com.management.student.exception.StudentServiceException;
import com.management.student.repository.StudentRepository;

@Service
public class AdmissionService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Integer addStudent(StudentDetails studentDTO) throws StudentServiceException{
		Student student = new Student();
		student.setStudentName(studentDTO.getStudentName());
		student.setTeacherId(studentDTO.getTeacherId());
		return studentRepository.save(student).getStudentId();
	}
	
	public Integer deleteStudent(Integer studentId) throws StudentServiceException{
		Optional<Student> optional = studentRepository.findById(studentId);
		optional.orElseThrow(() -> new StudentServiceException("No student found with the given Id"));
		Student student = optional.get();
		Integer id = student.getStudentId();
		studentRepository.delete(student);
		return id;
	}
	
	public Integer deleteStudent(String studentName) throws StudentServiceException{
		return null;
	}
	
	public Integer updateStudent(StudentDetails studentDTO) throws StudentServiceException{
		return null;
	}
}
