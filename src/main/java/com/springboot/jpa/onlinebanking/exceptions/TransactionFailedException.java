package com.springboot.jpa.onlinebanking.exceptions;

@SuppressWarnings("serial")
public class TransactionFailedException extends RuntimeException {
	
	public TransactionFailedException(String message) {
		super(message);
	}

}
