package com.mindtree.hospitalmanage.dto;

public class ExceptionDto {
	private String message;

	public ExceptionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionDto(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
