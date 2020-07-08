package com.springboot.jpa.onlinebanking.exceptions;

@SuppressWarnings("serial")
public class RequestFailedException extends RuntimeException {
	
	public RequestFailedException(String message) {
		super(message);
	}

}
