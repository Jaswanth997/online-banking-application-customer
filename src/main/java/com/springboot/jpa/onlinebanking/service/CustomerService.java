package com.springboot.jpa.onlinebanking.service;

import java.util.List;

import com.springboot.jpa.onlinebanking.entity.AtmSimulator;
import com.springboot.jpa.onlinebanking.entity.Beneficiary;
import com.springboot.jpa.onlinebanking.entity.Credit;
import com.springboot.jpa.onlinebanking.entity.CustomerDetails;
import com.springboot.jpa.onlinebanking.entity.PostNews;
import com.springboot.jpa.onlinebanking.entity.Request;
import com.springboot.jpa.onlinebanking.entity.TransactionDetails;
import com.springboot.jpa.onlinebanking.entity.TransferFunds;


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
