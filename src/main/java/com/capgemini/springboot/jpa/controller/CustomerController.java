package com.capgemini.springboot.jpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.jpa.entity.AtmSimulator;
import com.capgemini.springboot.jpa.entity.Beneficiary;
import com.capgemini.springboot.jpa.entity.Credit;
import com.capgemini.springboot.jpa.entity.CustomerDetails;
import com.capgemini.springboot.jpa.entity.PostNews;
import com.capgemini.springboot.jpa.entity.Request;
import com.capgemini.springboot.jpa.entity.TransactionDetails;
import com.capgemini.springboot.jpa.entity.TransferFunds;
import com.capgemini.springboot.jpa.exceptions.BeneficiaryNotFoundException;
import com.capgemini.springboot.jpa.exceptions.RequestFailedException;
import com.capgemini.springboot.jpa.exceptions.TransactionFailedException;
import com.capgemini.springboot.jpa.response.Response;
import com.capgemini.springboot.jpa.service.CustomerService;
  
@RestController
@RequestMapping("/api")
@CrossOrigin(origins= "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	//customer
	@GetMapping("/myTransaction/{id}")
 	public List<TransactionDetails> myTransaction(@PathVariable int id) {


 		return customerService.myTransaction(id);
 	}

 	@GetMapping("/myBeneficiary/{id}")
 	public List<Beneficiary> myBeneficiary(@PathVariable int id) {

 		return customerService.myBeneficiary(id);
 	}
	
	@GetMapping("/customer/{id}")

	public Response<CustomerDetails> getCustomerDetails(@PathVariable int id) {
		CustomerDetails customerDetails = customerService.findById(id);

		if (customerDetails != null) {
			return new Response<>(false,"Customer details found", customerDetails);
			
		}else {
			return new Response<>(true,"Customer details not found", null);
		}

	}
	
	
     @PostMapping("/atm/{id}")
 	public Response<AtmSimulator> atm(@PathVariable int id, @Valid @RequestBody AtmSimulator atm) {

 		String atm2 = customerService.atmSimulator(id, atm);

 		if (atm2 != null) {
 			return new Response<AtmSimulator>(false, atm2, null);
 		}
 		return null;
 	}

 	@PostMapping("/transfer/{id}")
 	public Response<TransferFunds> transferFunds(@PathVariable int id,@Valid  @RequestBody TransferFunds transferFunds) {

 		String transFunds = customerService.transferFunds(id, transferFunds);

 		if (transFunds != null) {
 			return new Response<>(false, transFunds, null);
 		}
 		return null;
 	}

 
 	@PostMapping("/credit/{id}")
 	public Response<Credit> transferFunds(@PathVariable int id,@Valid  @RequestBody Credit credit) {

 		String creditAmount = customerService.creditAmount(id, credit);

 		if (creditAmount == null) {
 			throw new TransactionFailedException("Transaction failed");
 		}else {
 			return new Response<>(false, creditAmount, null);
 		}
 	}
 	
 	//beneficiary
 	
 	 @DeleteMapping ("/deleteBeneficiary/{beneficiaryId}")
     public Response<Beneficiary> deleteBeneficiary(@PathVariable int beneficiaryId) {
     	 Beneficiary beneficiary =customerService.findByBeneficiaryId(beneficiaryId);
     	 
     	customerService.deleteById(beneficiaryId);
     	 
 	
 	if(beneficiary==null) {
 		throw new BeneficiaryNotFoundException("Beneficiary not found for id "+ beneficiaryId);// custom exception
 	}else {
 		return new Response<>(false,"Beneficiary deleted successfully", beneficiary);
 	}
 }
      
      @PostMapping("/addBeneficiary/{id}")
  	public Response<Beneficiary> addBeneficiary(@PathVariable int id, @Valid @RequestBody Beneficiary beneficiary) {
     	 
         Beneficiary result = customerService.findByFirstName(beneficiary.getFirstName()) ;
     	      	 
    	 Beneficiary result1 = customerService.findByAccountNumber(beneficiary.getAccountNumber()) ;
     	 
     	 Beneficiary result2 = customerService.findByEmail(beneficiary.getEmailId()) ;
  		
     	 Beneficiary result3 = customerService.findByPhoneNumber(beneficiary.getPhoneNumber()) ;
  		
  		
  		if(result !=null) {
  			return new Response<Beneficiary>(true, "Beneficiary with same name already exists" ,null);
  		}else if(result1 != null) {
  			return new Response<Beneficiary>(true, "Beneficiary with same Account Number already exists" ,null);
  		}else if(result2 != null) {
  			return new Response<Beneficiary>(true, "This Email already exists" ,null);
  		}else if(result3 != null) {
 			return new Response<Beneficiary>(true, "This Phone Number already exists" ,null);
 		}
  		
  		beneficiary.setBeneficiaryId(0);
                    
         String addBeneficiary = customerService.addBeneficiary(id, beneficiary);

  		if (addBeneficiary != null) {
  			return new Response<>(false, addBeneficiary, beneficiary);
  		}

  		return null;
  	}
      
      //request
      
      @GetMapping("/myRequest/{id}")
   	public List<Request> myRequest(@PathVariable int id) {


   		return customerService.myRequest(id);
   	}
  	
  	@PostMapping("/send-request/{id}")
  	public Response<Request> addRequest(@PathVariable int id,@RequestBody Request request) {
  		
  		request.setRequestId(0);
  		String requests=customerService.addRequest(id, request);
  		if(requests != null) {
  			
  			return new Response<>(false,requests, request);
  		}else {
  			throw new RequestFailedException("Request failed");
  		}
  		
  	}
  	
  	//news 
  	
  	@GetMapping("/get-news")
	public Response<List<PostNews>> findNews() {
		List<PostNews> lists = customerService.findAllNews();
		return new Response<>(false,"latest updates" ,lists);
	}
 

}

