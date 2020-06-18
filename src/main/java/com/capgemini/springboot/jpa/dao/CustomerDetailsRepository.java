package com.capgemini.springboot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.springboot.jpa.entity.CustomerDetails;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {
	
	@Query("from CustomerDetails where email_id=?1")
	CustomerDetails findbyEmail(String emailId);
	
	@Query("from CustomerDetails  where phone_no=?1")
	CustomerDetails findbyPhone(String phoneNumber);
	
	@Query("from CustomerDetails  where aadhar_no=?1")
	CustomerDetails findbyAadhar(String aadharNumber);
	
	@Query("from CustomerDetails  where account_no=?1")
	CustomerDetails findbyAccNo(String accountNumber);

}
