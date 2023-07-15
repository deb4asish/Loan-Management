package com.springboot.practice.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NaukriDTO {
	
	private String cName;
	private String phNum;
	private double currentSalary;
	private double expectedSalary;
	private String orgName;
	private String dob;
	private String yearpassing;
	private MultipartFile file;

}
