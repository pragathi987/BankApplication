package com.bankApplication.exceptionhandling;

public class AccountException extends RuntimeException{

	public AccountException(String message) {
		super(message);
	}

}
