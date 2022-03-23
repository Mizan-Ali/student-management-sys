package com.management.student.exception;

public class StudentServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	private String errorCode;

	public StudentServiceException(String code, String message) {
		super(message);
		this.errorCode = code;
	}

	public StudentServiceException(String message) {
		super(message);

	}
}