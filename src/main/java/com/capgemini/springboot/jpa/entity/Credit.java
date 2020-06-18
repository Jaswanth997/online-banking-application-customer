package com.capgemini.springboot.jpa.entity;

public class Credit {
	
	private String amount;
	
	public Credit() {
		
	}

	
	public Credit(String amount) {
		this.amount = amount;
	}


	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
