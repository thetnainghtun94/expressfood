package com.ExpressFood.Food.dto;

public class ResponseDto {
	
	private String status;
	private String message;
	
	public ResponseDto(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public ResponseDto(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDto [status=" + status + ", message=" + message + "]";
	}
	
	
	
}
