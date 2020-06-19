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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "request")
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "request_id")
	private int requestId;
	
	@Column(name= "request")
	private String request;
	
	@Column(name= "address")
	private String address;
	
	@Column(name= "phone_number")
	private String phoneNumber;
	
	@Column(name= "leaves")
	@NotNull(message = "please mention your number of leaves for chequebook")
	@Size(max=30, message ="please choose number of leaves below 30 only")
	private String leaves;
	
	@Column(name= "status")
	private String status;
	
	@Column(name= "details")
	private String details;
	
	@ManyToOne()
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private CustomerDetails customerDetails;
	
	public Request() {
		
	}


	public int getRequestId() {
		return requestId;
	}


	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}


	public String getRequest() {
		return request;
	}


	public void setRequest(String request) {
		this.request = request;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getLeaves() {
		return leaves;
	}


	public void setLeaves(String leaves) {
		this.leaves = leaves;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}


	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", request=" + request + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", leaves=" + leaves + ", status=" + status + ", details=" + details
				+ ", customerDetails=" + customerDetails + "]";
	}

	
}
