package com.capgemini.springboot.jpa.exceptions;

@SuppressWarnings("serial")
public class TransactionNotFoundException extends RuntimeException {
	
	public TransactionNotFoundException(String message) {
		super(message);
	}


}
