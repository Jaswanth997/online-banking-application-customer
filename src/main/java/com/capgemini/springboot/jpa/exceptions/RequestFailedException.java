package com.capgemini.springboot.jpa.exceptions;

@SuppressWarnings("serial")
public class RequestFailedException extends RuntimeException {
	
	public RequestFailedException(String message) {
		super(message);
	}

}
