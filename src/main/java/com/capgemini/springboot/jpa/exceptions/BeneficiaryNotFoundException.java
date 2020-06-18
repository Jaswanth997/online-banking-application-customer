package com.capgemini.springboot.jpa.exceptions;

@SuppressWarnings("serial")
public class BeneficiaryNotFoundException extends RuntimeException {
	
	public BeneficiaryNotFoundException(String message) {
		super(message);
	}


}
