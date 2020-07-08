package com.springboot.jpa.onlinebanking.exceptions;

@SuppressWarnings("serial")
public class EmailNotFoundException extends RuntimeException{
	
	public EmailNotFoundException(String message) {
		super(message);
	}


}
