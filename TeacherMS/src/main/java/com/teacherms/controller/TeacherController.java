package com.teacherms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacherms.dto.TeacherDTO;
import com.teacherms.service.TeacherService;

@RestController
@RequestMapping(value = "/teacherms")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/teachers/{teacherId}")
	public ResponseEntity<TeacherDTO> getTeacher(@PathVariable Integer teacherId) throws Exception {
		TeacherDTO teacherDTO = teacherService.getTeacher(teacherId);
		return new ResponseEntity<>(teacherDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/teacher")
	public ResponseEntity<String> addTeacher(@Valid @RequestBody TeacherDTO teacherDTO) throws Exception {
		Integer teacherId = teacherService.addTeacher(teacherDTO);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + teacherId;
		return new ResponseEntity<String>(successMessage, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "teacher/{teacherId}")
	public ResponseEntity<String> deleteTeacher(@PathVariable Integer teacherId) throws Exception {
		teacherService.deleteTeacher(teacherId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<String>(successMessage, HttpStatus.OK);
		
	}
}
