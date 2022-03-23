package com.teacherms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TeacherDTO {
	
	@NotNull(message = "{teacher.id.absent}") //fetch from validation.properties
	private Integer teacherId;
	
	@NotNull(message = "{teacher.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{teacher.name.invalid}")
	private String name;
	
	private String course;

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	
}
