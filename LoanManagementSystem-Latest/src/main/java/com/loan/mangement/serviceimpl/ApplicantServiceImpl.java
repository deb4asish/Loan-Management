package com.loan.mangement.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.loan.mangement.dao.ApplicantInfoDAO;
import com.loan.mangement.dao.EducationalDetailsDAO;
import com.loan.mangement.dto.LoanManagementRequestDTO;
import com.loan.mangement.dto.LoanManagementResponseDTO;
import com.loan.mangement.exception.CardNotValidException;
import com.loan.mangement.repo.IApplicantInfoRepo;
import com.loan.mangement.repo.IEducationalDetailsRepo;
import com.loan.mangement.service.IApplicantsService;
import com.loan.mangement.service.IEducationalDetailsService;

@Service
public class ApplicantServiceImpl implements IApplicantsService, IEducationalDetailsService {
	@Autowired
	IApplicantInfoRepo applicantinfo;
	@Autowired
	IEducationalDetailsRepo educationaldetailrepo;

	EducationalDetailsDAO educationaldetaildao;

	ApplicantInfoDAO applicantDAO;

	LoanManagementResponseDTO responseDTO;

	// @Transactional
	public String saveApplicantInfo(LoanManagementRequestDTO loanreqDTO) {
		applicantDAO = new ApplicantInfoDAO();

		if (loanreqDTO.getAplcntAdhaarNumber().isEmpty()) {
			throw new CardNotValidException("Adhaar Card cant be null");
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

			String dateInString1 = loanreqDTO.getAplcntdob();
			Date date = null;
			try {
				date = formatter.parse(dateInString1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

			String dateInString2 = loanreqDTO.getGntrDob();
			Date gdate = null;
			try {
				gdate = formatter1.parse(dateInString2);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			applicantDAO.setAplcntAdharNumber(loanreqDTO.getAplcntAdhaarNumber());
			applicantDAO.setAplcntName(loanreqDTO.getAplcntName());
			applicantDAO.setAplcntphNumber(loanreqDTO.getAplcntPhNumber());
			applicantDAO.setAplcntgender(loanreqDTO.getAplcntGender());
			applicantDAO.setFatherName(loanreqDTO.getFatherName());
			applicantDAO.setMotherName(loanreqDTO.getMotherName());
			applicantDAO.setAplcntDob(date);
			applicantDAO.setAnnualIncome(loanreqDTO.getAnnualIncome());
			applicantDAO.setGntrAdharNumber(loanreqDTO.getGntrAdhaarNumber());
			applicantDAO.setGntrGender(loanreqDTO.getGuarantorGender());
			applicantDAO.setGntrDob(gdate);
			applicantDAO.setGntrName(loanreqDTO.getGntrName());
			applicantDAO.setGntrPhNumber(loanreqDTO.getGntrPhNumber());
			applicantDAO.setOccupation(loanreqDTO.getOccupation());
			applicantDAO.setEducationaldao(educationaldetaildao);

			applicantinfo.save(applicantDAO);

			List<ApplicantInfoDAO> list = applicantinfo.getAllApplicantInfo();

			list.stream().forEach(AllApplicantInfo -> System.out.println(AllApplicantInfo));

			return "ApplicationInfo Inserted Successfully";
		}
	}

	// @Transactional
	public String saveEduacationalDetails(LoanManagementRequestDTO loanreqDTO) {
		educationaldetaildao = new EducationalDetailsDAO();
		educationaldetaildao.setAplcntAdharNumber(loanreqDTO.getAplcntAdhaarNumber());
		educationaldetaildao.setCourseEndDate(loanreqDTO.getCourseEndDate());
		educationaldetaildao.setCourseStartDate(loanreqDTO.getCourseStartDate());
		educationaldetaildao.setPercentage(loanreqDTO.getPercentage());
		educationaldetaildao.setQualification(loanreqDTO.getQualification());
		educationaldetaildao.setUniversity(loanreqDTO.getUniversity());

		educationaldetailrepo.save(educationaldetaildao);

		return "Educational Details Inserted Successfully";
	}

	List<LoanManagementResponseDTO> getSpecifcApplicantDetails(int startPage, int endpage) {
		responseDTO = new LoanManagementResponseDTO();
		List<LoanManagementResponseDTO> listResponse = new ArrayList<>();
		Pageable page = PageRequest.of(startPage, endpage);
		Page<ApplicantInfoDAO> allPages = applicantinfo.findAll(page);
		List<ApplicantInfoDAO> getAllData = allPages.getContent();
		for (int i = 0; i < getAllData.size(); i++) {
			responseDTO = new LoanManagementResponseDTO();
			responseDTO.setAplcntAdharNumber(getAllData.get(i).getAplcntAdharNumber());
			responseDTO.setAplcntgender(getAllData.get(i).getAplcntgender());
			listResponse.add(responseDTO);
		}

		return listResponse;

	}
}