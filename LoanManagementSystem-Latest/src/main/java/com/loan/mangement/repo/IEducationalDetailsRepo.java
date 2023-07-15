package com.loan.mangement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.mangement.dao.EducationalDetailsDAO;

public interface IEducationalDetailsRepo extends JpaRepository<EducationalDetailsDAO, String>{

	
}
