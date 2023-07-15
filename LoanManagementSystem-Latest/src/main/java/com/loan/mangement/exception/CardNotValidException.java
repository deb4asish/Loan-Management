package com.loan.mangement.exception;

public class CardNotValidException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CardNotValidException(String message){
		super(message);
	}
	
}
