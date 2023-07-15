package com.loan.mangement.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EducationalDetailsDAO {
	
	@Id
	private String aplcntAdharNumber;
	private String qualification;
	private String university;
	private String percentage;
	private String courseStartDate;
	private String courseEndDate;
	
//	@OneToOne(mappedBy = "educationaldao")
//	private ApplicantInfoDAO applicantsdao;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="fk_aplcnt_adhar_number")
//	private ApplicantInfoDAO applicantsdao;
//	
	
}
