package com.teacherms.service;

import com.teacherms.dto.TeacherDTO;
import com.teacherms.exception.TeacherException;

public interface TeacherService {
	// Adds a teacher to the db and returns the teacherId
	public Integer addTeacher(TeacherDTO teacherDTO) throws TeacherException;
	
	// deletes a teacher record on the basis of teacherId
	public void deleteTeacher(Integer teacherId) throws TeacherException;
	
	public TeacherDTO getTeacher(Integer teacherId) throws TeacherException;

	/* Left for implementation
	deleteTeacher(name)
	updateTeacher(id) 
	 */
}
