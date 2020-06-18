package com.capgemini.springboot.jpa.exceptions;

@SuppressWarnings("serial")
public class CustomerNotAddedException extends RuntimeException {
	
	public CustomerNotAddedException(String message) {
		super(message);
	}


}
