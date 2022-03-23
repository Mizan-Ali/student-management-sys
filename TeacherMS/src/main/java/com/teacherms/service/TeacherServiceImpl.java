package com.teacherms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacherms.dto.TeacherDTO;
import com.teacherms.entity.Teacher;
import com.teacherms.exception.TeacherException;
import com.teacherms.repository.TeacherRepository;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public Integer addTeacher(TeacherDTO teacherDTO) throws TeacherException {
		// check if the record already exists
		Optional<Teacher> teacherRecord = teacherRepository.findById(teacherDTO.getTeacherId());
		
		if(teacherRecord != null) 
			throw new TeacherException("Service.TEACHER_RECORD_ALREADY_EXISTS");
		
		TeacherDTO teacher = new TeacherDTO();
		teacher.setCourse(teacherDTO.getCourse());
		teacher.setName(teacherDTO.getName());
		teacher.setTeacherId(teacherDTO.getTeacherId());
		
		return teacher.getTeacherId();
				
	}

	@Override
	public void deleteTeacher(Integer teacherId) throws TeacherException {
		Optional<Teacher> teacher = teacherRepository.findById(teacherId);
		if(teacher == null) 
			throw new TeacherException("Service.TEACHER_NOT_FOUND");
		teacherRepository.deleteById(teacherId);
	}

	@Override
	public TeacherDTO getTeacher(Integer teacherId) throws TeacherException {
		Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);
		Teacher teacher = teacherOptional.orElseThrow(()-> new TeacherException("Service.TEACHER_NOT_FOUND"));
		
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setTeacherId(teacher.getTeacherId());
		teacherDTO.setName(teacher.getName());
		teacherDTO.setCourse(teacher.getCourse());
		
		return teacherDTO;
	}

}
