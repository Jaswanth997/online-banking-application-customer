package com.capgemini.springboot.jpa.exceptions;

@SuppressWarnings("serial")
public class TransactionFailedException extends RuntimeException {
	
	public TransactionFailedException(String message) {
		super(message);
	}

}
