package com.springboot.jpa.onlinebanking.exceptions;

@SuppressWarnings("serial")
public class TransactionNotFoundException extends RuntimeException {
	
	public TransactionNotFoundException(String message) {
		super(message);
	}


}
