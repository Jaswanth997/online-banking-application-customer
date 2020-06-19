package com.capgemini.springboot.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name ="transactions")
public class TransactionDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Integer transactionId;
	
	@Column(name="date_and_time")
	@NotNull
	@DateTimeFormat
	private Date date;
	
	@Column
	@NotNull
	private String remarks;
	
	@NotNull
	@Column
	private String credit;
	
	@NotNull
	@Column
	private String debit;
	
	@Column
	@NotNull
	private String balance;
	
	@Column
	@NotNull
	private String id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private CustomerDetails customerDetails;
	
	public TransactionDetails() {
		
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getDebit() {
		return debit;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", date=" + date + ", remarks=" + remarks
				+ ", credit=" + credit + ", debit=" + debit + ", balance=" + balance + ", id=" + id
				+ ", customerDetails=" + customerDetails + "]";
	}

	
}

