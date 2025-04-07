package com.example.demo.exceptions;

public class ErrorMessage {
	private int statusCode;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	public ErrorMessage(int statusCode, String message) {
		this.message=message;
		this.statusCode=statusCode;
	}

}
