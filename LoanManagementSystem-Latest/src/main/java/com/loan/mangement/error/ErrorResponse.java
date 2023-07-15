package com.loan.mangement.error;

import lombok.Data;

@Data
public class ErrorResponse {

	int statusCode;
	
	String errorMessage;
	
	public ErrorResponse(int statusCode,String errorMessage){
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}
}
