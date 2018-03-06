package com.monamitech.lendme.calculator.dto;

public class Message {
	public int status;
	public String message;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Message(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Message() {
		super();
	}

}
