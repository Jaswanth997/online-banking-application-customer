package com.capgemini.springboot.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name= "beneficiary_details")
public class Beneficiary implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "beneficiary_id")
	private int beneficiaryId;
	
	@Column(name= "first_name")
	@NotNull(message = "please enter first name")
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[a-zA-Z ]*{3,20}", message = "please enter alphabets only and atleast 3 characters")
	private String  firstName;
	
	@Column(name= "last_name")
	@NotNull(message = "please enter last name")
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[a-zA-Z ]*{1,20}", message = "please enter alphabets only")
	private String lastName;
	
	@Column(name= "account_number")
	@NotNull(message = "please enter account number")
	@Pattern(regexp = "[0-9]{16}", message = "please enter 16 digit account number ")
	private String accountNumber;
	
	@Column(name= "email_id")
	@NotNull(message = "please enter emailId")
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "please enter proper email format(ex: abc@gmail.com)")
	private String emailId;
	
	@Column(name= "phone_number")
	@NotNull(message = "please enter phone number")
	@Pattern(regexp =  "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[6789]\\d{9}$", message = "phone number should start between (6-9) and it contains 10 digits")
	private String phoneNumber;
	
	@ManyToOne()
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private CustomerDetails customerDetails;
	
	
	public Beneficiary() {
		
	}


	public int getBeneficiaryId() {
		return beneficiaryId;
	}


	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}


	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	
}
