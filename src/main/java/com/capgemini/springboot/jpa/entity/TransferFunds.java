package com.capgemini.springboot.jpa.entity;

import javax.validation.constraints.NotNull;

public class TransferFunds {
	
	@NotNull
	private String receiverName;
	
	@NotNull
	private String accountNumber;
	
	@NotNull
	private String amount;
	
	@NotNull
	private String pin;
	
	public TransferFunds() {
		
	}

	

	public String getReceiverName() {
		return receiverName;
	}



	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}



	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	
}
