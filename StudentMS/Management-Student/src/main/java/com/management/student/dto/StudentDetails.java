package com.management.student.dto;

import javax.validation.constraints.NotNull;

public class StudentDetails {

	@NotNull(message = "StudentId cannot be Null")
	private int studentId;
	@NotNull(message = "StudentName cannot be Null")
	private String studentName;
	private int teacherId;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
}
