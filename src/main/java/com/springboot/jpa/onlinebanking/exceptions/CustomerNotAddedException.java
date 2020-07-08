package com.springboot.jpa.onlinebanking.exceptions;

@SuppressWarnings("serial")
public class CustomerNotAddedException extends RuntimeException {
	
	public CustomerNotAddedException(String message) {
		super(message);
	}


}
