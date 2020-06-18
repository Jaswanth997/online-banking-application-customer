package com.capgemini.springboot.jpa.service;

import java.util.List;

import com.capgemini.springboot.jpa.entity.AtmSimulator;
import com.capgemini.springboot.jpa.entity.Beneficiary;
import com.capgemini.springboot.jpa.entity.Credit;
import com.capgemini.springboot.jpa.entity.CustomerDetails;
import com.capgemini.springboot.jpa.entity.PostNews;
import com.capgemini.springboot.jpa.entity.Request;
import com.capgemini.springboot.jpa.entity.TransactionDetails;
import com.capgemini.springboot.jpa.entity.TransferFunds;


public interface CustomerService {
   //customer
	public CustomerDetails findById(int customerId);
	
	public List<Beneficiary> myBeneficiary(int id);
	
	public String atmSimulator(int id, AtmSimulator atm);
	
	public String transferFunds(int id, TransferFunds transferFunds);
	
	public List<TransactionDetails> myTransaction(int id);
	
	public String creditAmount(int id, Credit credit);

	public List<CustomerDetails> findAllCustomers(CustomerDetails customerDetails);
	
	//beneficiary
	
	 public Beneficiary findByBeneficiaryId(int beneficiaryId);
	    
	 public Beneficiary findByFirstName(String firstName);
	    
	 public Beneficiary findByLastName(String lastName);
	    
	 public Beneficiary findByEmail(String emailId);
	    
	 public Beneficiary findByAccountNumber(String accountNumber);
	    
	 public Beneficiary findByPhoneNumber(String phoneNumber);
	 
	 public String addBeneficiary(int id, Beneficiary beneficiary);
		
	 public void deleteById(int beneficiaryId);

	 public List<Beneficiary> findAllBeneficiaries(Beneficiary beneficiary);

     //request
	 
	 public String addRequest(int id,Request request);
	    
	 public List<Request> myRequest(int id);
	 
	 //news
	 
	 public List<PostNews> findAllNews();

	
	
}
