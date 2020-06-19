package com.capgemini.springboot.jpa.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class AtmSimulator {
	
	private int id;
	
	@NotNull(message= "please enter your card ")
	private String  card;
	
	@NotNull(message= "please enter amount")
	private String amount;
	
	@NotNull(message ="please enter your pin")
	@Pattern(regexp = "[0-9]{4}", message = "please enter 4 digits only")
	private String pin;
	
	public AtmSimulator() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
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
