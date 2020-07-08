package com.springboot.jpa.onlinebanking.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name= "customer_details")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "customer_id")
	private int customerId;
	
	@Column(name= "first_name")
	@NotNull(message = "please enter first name")
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[a-zA-Z ]*{3,20}", message = "please enter alphabets only and atleast 3 characters")
	private String firstName;
	
	@Column(name= "last_name")
	@NotNull(message = "please enter last name")
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[a-zA-Z ]*{1,20}", message = "please enter alphabets only")
	private String lastName;
	
	@Column(name= "gender")
	@NotNull(message = "please mention gender")
	@Pattern(regexp = "^(?:m|M|male|Male|f|F|female|Female)$", message = "please enter gender(male/female)")
	private String gender;
	
	@Column(name= "date_of_birth")
	@NotNull(message = "please enter date of birth")
	private String dateOfBirth;
	
	@Column(name= "aadhar_no",unique= true)
	@NotNull(message = "please enter aadhar number")
	@Pattern(regexp = "[0-9]{12}", message = "please enter your correct 12 digits aadhar number")
	private String aadharNumber;
	
	@Column(name= "email_id",unique= true)
	@NotNull(message = "please enter emailId")
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "please enter proper email format(ex: abc@gmail.com)")
	private String emailId;
	
	@Column(name= "phone_no",unique= true)
	@NotNull(message = "please enter phone number")
	@Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[6789]\\d{9}$", message = "phone number should start between (6-9) and it should contain 10 digits only")
	private String phoneNumber;
	
	@Column(name= "address")
	@NotNull(message = "please mention your address")
	private String address;
	
	@Column(name= "bank_branch")
	@NotNull(message = "please enter your bank branch")
	private String bankBranch;
	
	@Column(name= "account_no")
	@Pattern(regexp = "[0-9]{16}", message = "please enter a valid 16 digits account number ")
	private String accountNumber;
	
	@Column(name= "opening_balance")
	@NotNull(message = "please enter amount")
	private String openingBalance;
	
	@Column(name= "pin")
	//@Pattern(regexp = "[0-9]{4}", message = "please enter 4 digits only")
	private String pin;
	
	@Column(name= "password",unique= true)
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "password should consists of atleast 8 characters with one uppercase,one lowercase and one special character")
	private String password;
	
	@Column
	@NotNull(message= "please mention role")
	private String role;
	
	@OneToMany(mappedBy = "customerDetails",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Beneficiary> beneficiaryList;
	
	@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TransactionDetails> transcationDetailsList;
	
	@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Request> requestList; ;
	
	public CustomerDetails() {
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

		public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Beneficiary> getBeneficiaryList() {
		return beneficiaryList;
	}

	public void setBeneficiaryList(List<Beneficiary> beneficiaryList) {
		this.beneficiaryList = beneficiaryList;
	}

	public List<TransactionDetails> getTranscationDetailsList() {
		return transcationDetailsList;
	}

	public void setTranscationDetailsList(List<TransactionDetails> transcationDetailsList) {
		this.transcationDetailsList = transcationDetailsList;
	}

	public List<Request> getRequestList() {
		return requestList;
	}

	public void setRequestList(List<Request> requestList) {
		this.requestList = requestList;
	}

	
}
