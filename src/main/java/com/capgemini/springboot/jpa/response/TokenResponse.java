package com.capgemini.springboot.jpa.response;

public class TokenResponse<T> {
	
	private boolean error;
	
	private String message;
	
	private String Token;
	
     T data;
     
     public TokenResponse() {
    	 
     }

	public TokenResponse(boolean error, String message, String token, T data) {
		this.error = error;
		this.message = message;
		Token = token;
		this.data = data;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TokenResponse [error=" + error + ", message=" + message + ", Token=" + Token + ", data=" + data + "]";
	}

	
}
