package com.springboot.jpa.onlinebanking.exceptions;

@SuppressWarnings("serial")
public class BeneficiaryNotFoundException extends RuntimeException {
	
	public BeneficiaryNotFoundException(String message) {
		super(message);
	}


}
