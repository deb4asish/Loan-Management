package com.loan.mangement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loan.mangement.dao.ApplicantInfoDAO;

public interface IApplicantInfoRepo extends JpaRepository<ApplicantInfoDAO, String>{
	
	@Query(value="select * from applicant_infodao Natural join educational_detailsdao", nativeQuery =true )
	List<ApplicantInfoDAO> getAllApplicantInfo();
}
