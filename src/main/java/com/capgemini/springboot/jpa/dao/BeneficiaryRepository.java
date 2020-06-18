package com.capgemini.springboot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.springboot.jpa.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

	@Query("from Beneficiary  where first_name=?1")
	Beneficiary findbyFirstName(String firstName);
	
	@Query("from Beneficiary  where last_name=?1")
	Beneficiary findbyLastName(String lastName);
	
	@Query("from Beneficiary where email_id=?1")
	Beneficiary findbyEmail(String emailId);
	
	@Query("from Beneficiary  where account_number=?1")
	Beneficiary findbyAccountNumber(String accountNumber);
	
	@Query("from Beneficiary  where phone_number=?1")
	Beneficiary findbyPhoneNumber(String phoneNumber);
	
	
}
