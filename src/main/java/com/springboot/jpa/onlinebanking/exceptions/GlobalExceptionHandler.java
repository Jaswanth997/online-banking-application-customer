package com.springboot.jpa.onlinebanking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.jpa.onlinebanking.entity.Beneficiary;
import com.springboot.jpa.onlinebanking.entity.CustomerDetails;
import com.springboot.jpa.onlinebanking.entity.Request;
import com.springboot.jpa.onlinebanking.entity.TransactionDetails;
import com.springboot.jpa.onlinebanking.response.ErrorResponse;
import com.springboot.jpa.onlinebanking.response.Response;
import com.springboot.jpa.onlinebanking.response.TokenResponse;


@ControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<Response<CustomerDetails>> handleCustomerDetailsException(CustomerNotAddedException exc) {
		Response<CustomerDetails> response = new Response<CustomerDetails>(true,exc.getMessage(),null);
		
		return new ResponseEntity<Response<CustomerDetails>>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<Response<Beneficiary>> handleException(BeneficiaryNotFoundException exc) {
		Response<Beneficiary> response = new Response<Beneficiary>(true,exc.getMessage(),null);
		
		return new ResponseEntity<Response<Beneficiary>>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<Response<TransactionDetails>> handleException(TransactionNotFoundException exc) {
		Response<TransactionDetails> response = new Response<TransactionDetails>(true,exc.getMessage(),null);
		
		return new ResponseEntity<Response<TransactionDetails>>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<Response<Request>> handleException(RequestFailedException exc) {
		Response<Request> response = new Response<Request>(true,exc.getMessage(),null);
		
		return new ResponseEntity<Response<Request>>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<Response<TransactionDetails>> handleTransactionDetailsException(TransactionFailedException exc) {
		Response<TransactionDetails> response = new Response<TransactionDetails>(true,exc.getMessage(),null);
		
		return new ResponseEntity<Response<TransactionDetails>>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleCustomValidationError(MethodArgumentNotValidException ex){
		ErrorResponse error=new ErrorResponse(true,ex.getBindingResult().getFieldError().getDefaultMessage(),null);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<TokenResponse<CustomerDetails>> handleException(EmailNotFoundException exc) {
		TokenResponse<CustomerDetails> response = new TokenResponse<CustomerDetails>(true,exc.getMessage(),null,null);
		
		return new ResponseEntity<TokenResponse<CustomerDetails>>(response, HttpStatus.BAD_REQUEST);
	}

}
