package com.loan.mangement.dto;

public class AdharCardValidationResponseDTO {
	
	private String adharNumber;
    private String validationStatus;
    private String personName;
    private String personFatherName;
	public final String getAdharNumber() {
		return adharNumber;
	}
	public final void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	public final String getValidationStatus() {
		return validationStatus;
	}
	public final void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}
	public final String getPersonName() {
		return personName;
	}
	public final void setPersonName(String personName) {
		this.personName = personName;
	}
	public final String getPersonFatherName() {
		return personFatherName;
	}
	public final void setPersonFatherName(String personFatherName) {
		this.personFatherName = personFatherName;
	}
	public AdharCardValidationResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
