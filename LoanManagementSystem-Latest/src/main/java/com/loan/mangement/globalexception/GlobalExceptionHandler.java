package com.loan.mangement.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.loan.mangement.error.ErrorResponse;
import com.loan.mangement.exception.CardNotValidException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = CardNotValidException.class)
	public ResponseEntity<ErrorResponse> cardNotValidException(CardNotValidException message){
		ErrorResponse err = new ErrorResponse(100,message.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(err);
	}

}
