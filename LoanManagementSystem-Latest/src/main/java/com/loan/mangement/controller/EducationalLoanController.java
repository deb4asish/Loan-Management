package com.loan.mangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loan.mangement.dto.AdharCardValidationRequestDTO;
import com.loan.mangement.dto.AdharCardValidationResponseDTO;
import com.loan.mangement.dto.LoanManagementRequestDTO;
import com.loan.mangement.serviceimpl.ApplicantServiceImpl;

@RestController
public class EducationalLoanController {
	
	@Autowired
	ApplicantServiceImpl appdto;
	
	RestTemplate res=new RestTemplate();
	AdharCardValidationRequestDTO adharReqdto = new AdharCardValidationRequestDTO();
	AdharCardValidationResponseDTO adharResdto = new AdharCardValidationResponseDTO();
	
	@GetMapping("/saveApplicantData")
	public ResponseEntity<String> getApplicantDetails(@RequestBody LoanManagementRequestDTO lmrdto){
		String applicantinfo = appdto.saveApplicantInfo(lmrdto);
		String educationaldetails = appdto.saveEduacationalDetails(lmrdto);

		 return ResponseEntity.status(HttpStatus.OK).body(applicantinfo.concat(" "+educationaldetails));
		
	}
	
	
	
}