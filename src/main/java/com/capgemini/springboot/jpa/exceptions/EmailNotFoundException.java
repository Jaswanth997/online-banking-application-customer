package com.capgemini.springboot.jpa.exceptions;

@SuppressWarnings("serial")
public class EmailNotFoundException extends RuntimeException{
	
	public EmailNotFoundException(String message) {
		super(message);
	}


}
