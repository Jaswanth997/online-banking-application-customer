package com.capgemini.springboot.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.jpa.dao.BeneficiaryRepository;
import com.capgemini.springboot.jpa.dao.CustomerDetailsRepository;
import com.capgemini.springboot.jpa.dao.PostNewsRepository;
import com.capgemini.springboot.jpa.dao.RequestRepository;
import com.capgemini.springboot.jpa.entity.AtmSimulator;
import com.capgemini.springboot.jpa.entity.Beneficiary;
import com.capgemini.springboot.jpa.entity.Credit;
import com.capgemini.springboot.jpa.entity.CustomerDetails;
import com.capgemini.springboot.jpa.entity.PostNews;
import com.capgemini.springboot.jpa.entity.Request;
import com.capgemini.springboot.jpa.entity.TransactionDetails;
import com.capgemini.springboot.jpa.entity.TransferFunds;
import com.capgemini.springboot.jpa.exceptions.BeneficiaryNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDetailsRepository customerDetailsRepository;
	private BeneficiaryRepository beneficiaryRepository;
	private RequestRepository requestRepository;
	private PostNewsRepository postNewsRepository;

	@Autowired
	public CustomerServiceImpl(CustomerDetailsRepository CustomerDetailsRepository,
			BeneficiaryRepository BeneficiaryRepository,
			RequestRepository RequestRepository,
			PostNewsRepository PostNewsRepository) {
		this.customerDetailsRepository = CustomerDetailsRepository;
		this.beneficiaryRepository = BeneficiaryRepository;
		this.requestRepository = RequestRepository;
		this.postNewsRepository  =  PostNewsRepository;

	}
   

	@Override
	public CustomerDetails findById(int customerId) {
		Optional<CustomerDetails> result = customerDetailsRepository.findById(customerId);

		CustomerDetails customerDetails = null;
		if (result.isPresent()) {
			customerDetails = result.get();
		} 
		return customerDetails;
	}

	@Override
	public String atmSimulator(int id, AtmSimulator atm) {
		String message = "";

		CustomerDetails customer = customerDetailsRepository.findById(id).get();

		if (customer != null) {

			double balance = Double.parseDouble(customer.getOpeningBalance());
			double withdraw = Double.parseDouble(atm.getAmount());

			if (balance > withdraw) {

				if (atm.getPin().equals(customer.getPin())) {

					List<TransactionDetails> transaction = new ArrayList<TransactionDetails>();
					balance = balance - withdraw;

					customer.setOpeningBalance(balance + "");

					TransactionDetails transferDetails = new TransactionDetails();
					transferDetails.setDebit(withdraw + "");
					transferDetails.setCredit(0.0 + "");
					transferDetails.setBalance(balance + "");
					transferDetails.setDate(new Date());
					transferDetails.setRemarks("Withdrawn By ATM");
					transferDetails.setId("Transaction Done by Customer Id: " + customer.getCustomerId());
					transferDetails.setCustomerDetails(customer);

					transaction.add(transferDetails);

					customer.setTranscationDetailsList(transaction);

					customerDetailsRepository.save(customer);

					message = "Transaction Successful!";
				} else {
					message = "you entered wrong pin";
				}
			} else {
				message = "Don't have sufficient balance";
			}
		} else {
			message = "Id not found";
		}

		return message;

	}

	@Override
	public String transferFunds(int id, TransferFunds transferFunds) {
		String message = "";

		CustomerDetails customer = customerDetailsRepository.findById(id).get();

		if (customer != null) {

			boolean result = false;

			for (Beneficiary beneficiary : customer.getBeneficiaryList()) {

				if (transferFunds.getAccountNumber().equals(beneficiary.getAccountNumber())) {
					result = true;
				} else {
					message = "Invalid Account number";
				}
			}

			if (result) {
				double balance = Double.parseDouble(customer.getOpeningBalance());
				double transAmount = Double.parseDouble(transferFunds.getAmount());

				if (balance > transAmount) {

					if (transferFunds.getPin().equals(customer.getPin())) {

						List<TransactionDetails> transaction = new ArrayList<TransactionDetails>();
						balance = balance - transAmount;

						customer.setOpeningBalance(balance + "");

						TransactionDetails transferDetails = new TransactionDetails();
						transferDetails.setDebit(transAmount + "");
						transferDetails.setCredit(0.0 + "");
						transferDetails.setBalance(balance + "");
						transferDetails.setDate(new Date());
						transferDetails.setId("Transaction Done by Customer Id: " + customer.getCustomerId());
						transferDetails
								.setRemarks("Transfer to Beneficiary, ACC.NO:" + transferFunds.getAccountNumber());
						transferDetails.setCustomerDetails(customer);

						transaction.add(transferDetails);

						customer.setTranscationDetailsList(transaction);

						customerDetailsRepository.save(customer);
						
						message = "Transaction Successful!";

					} else {
						message = "you entered incorrect pin";
					}

				} else {
					message = "Dont have sufficient balance";
				}
			}
		}

		return message;

	}

	@Override
	public List<TransactionDetails> myTransaction(int transactionId) {
		CustomerDetails customer = customerDetailsRepository.findById(transactionId).get();

		if (customer != null) {
			return customer.getTranscationDetailsList();
		}
		return null;

	}

	@Override
	public List<Beneficiary> myBeneficiary(int beneficiaryId) {

		CustomerDetails customer = customerDetailsRepository.findById(beneficiaryId).get();

		if (customer != null) {
			return customer.getBeneficiaryList();
		}
		return null;
	}

	@Override
	public String creditAmount(int id, Credit credit) {

			String message = "";

			CustomerDetails customer = customerDetailsRepository.findById(id).get();

			if (customer != null) {
				double amount1 = Double.parseDouble(customer.getOpeningBalance());

				double camt = Double.parseDouble(credit.getAmount());

				double add = amount1 + camt;

				customer.setOpeningBalance(add + "");
				
				List<TransactionDetails> transaction = new ArrayList<TransactionDetails>();
				
				TransactionDetails transferDetails = new TransactionDetails();
				
				transferDetails.setDebit(0.00 + "");
				transferDetails.setCredit(credit.getAmount() + "");
				transferDetails.setBalance(add + "");
				transferDetails.setDate(new Date());
				transferDetails.setId("Money deposited by Customer Id: " + customer.getCustomerId());
				transferDetails
						.setRemarks("Money sent to self");
				transferDetails.setCustomerDetails(customer);
				
                transaction.add(transferDetails);

				customer.setTranscationDetailsList(transaction);

				customerDetailsRepository.save(customer);

				message = "Money Credited Successfully!";
			}

			return message;
		}

	
	@Override
	public List<CustomerDetails> findAllCustomers(CustomerDetails customerDetails) {
		return customerDetailsRepository.findAll();
	}
	
   
	//beneficiary
	
	@Override
	public Beneficiary findByBeneficiaryId(int beneficiaryId) {
		
        Optional<Beneficiary> result = beneficiaryRepository.findById(beneficiaryId);
		
        Beneficiary beneficiary=null;
		if(result.isPresent()) {
			beneficiary=result.get();
		}else {
			throw new BeneficiaryNotFoundException("Beneficiary id not found : "+beneficiaryId);//custom exception
		}
		return beneficiary;
	}


	@Override
	public void deleteById(int beneficiaryId) {
		beneficiaryRepository.deleteById(beneficiaryId);
	}

	@Override
	public String addBeneficiary(int id, Beneficiary beneficiary) {

			String message = "";
			CustomerDetails customer = customerDetailsRepository.findById(id).get();

			if (customer == null) {
				message = "Customer not found";
				return message;
			} else {
				beneficiary.setCustomerDetails(customer);

				beneficiaryRepository.save(beneficiary);
				
				message = "Beneficiary added Successfully";
			}
			return message;
		}



	@Override
	public Beneficiary findByFirstName(String firstName) {
		return beneficiaryRepository.findbyFirstName(firstName);
	}



	@Override
	public Beneficiary findByLastName(String lastName) {
		return beneficiaryRepository.findbyLastName(lastName);
	}



	@Override
	public Beneficiary findByEmail(String emailId) {
		return beneficiaryRepository.findbyEmail(emailId);
	}



	@Override
	public Beneficiary findByAccountNumber(String accountNumber) {
		return beneficiaryRepository.findbyAccountNumber(accountNumber);
	}



	@Override
	public Beneficiary findByPhoneNumber(String phoneNumber) {
		return beneficiaryRepository.findbyPhoneNumber(phoneNumber);
	}



	@Override
	public List<Beneficiary> findAllBeneficiaries(Beneficiary beneficiary) {
		return beneficiaryRepository.findAll();
	}
	
	//request
	

	@Override
	public String addRequest(int id, Request request) {
		
		String message ="";
		
		CustomerDetails customer = customerDetailsRepository.findById(id).get();
		
		if(customer != null) {
			request.setDetails("This request was sent by account number:"+ customer.getAccountNumber());
			request.setCustomerDetails(customer);
			message ="Request sent Successfully";
			
		requestRepository.save(request);
		}
		return message;
	}

	@Override
	public List<Request> myRequest(int id) {
		
		CustomerDetails customer = customerDetailsRepository.findById(id).get();
		if(customer != null) {
			return customer.getRequestList();
		}
		return null;
	}
	
	//news
	
	@Override
	public List<PostNews> findAllNews() {
		return postNewsRepository.findAll();
	}

}
