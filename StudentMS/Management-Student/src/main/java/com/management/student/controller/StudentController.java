package com.management.student.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.management.student.dto.StudentDetails;
import com.management.student.exception.StudentServiceException;
import com.management.student.service.AdmissionService;

@RestController
@RequestMapping(value="/student")
public class StudentController {

	@Autowired
	private AdmissionService admissionService;
	
	@PostMapping(value="/")
	public ResponseEntity<String> addStudent(@Valid @RequestBody StudentDetails studentDTO) throws StudentServiceException{
		try {
			Integer id = admissionService.addStudent(studentDTO);
			String res = "Student with Id: "+ id + " successfully added.";
			return new ResponseEntity<String>(res, HttpStatus.OK);
		}
		catch(StudentServiceException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@DeleteMapping(value="/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) throws StudentServiceException{
		try {
			Integer id = admissionService.deleteStudent(studentId);
			String res = "Student with Id: "+ id + " successfully added.";
			return new ResponseEntity<String>(res, HttpStatus.OK);
		}
		catch(StudentServiceException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
}
