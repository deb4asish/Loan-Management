package com.loan.mangement.dao;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ApplicantInfoDAO {

	
	@Id
	private String aplcntAdharNumber;
		
	private String aplcntName;
		
	private String aplcntphNumber;
		
	private String aplcntgender;
	
	private String fatherName;
	
	private String motherName;
	
	private Date aplcntDob;
	
	private String gntrName;
	
	private String gntrPhNumber;
	
	private String gntrGender;

	private Date gntrDob;
	
	private String gntrAdharNumber;
	
	private String occupation;
	
	private String annualIncome;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EducationalDetailsDAO educationaldao;
	
	
}
