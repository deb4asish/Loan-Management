package com.springboot.practice.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.practice.dto.NaukriDTO;

@Controller
public class NaukriPortalController {
	@Autowired
	ResourceLoader resource;

	@RequestMapping("/")
	public String callUI() {
		return "naukri.jsp";
	}

	@RequestMapping("/getInfo")
	public ModelAndView getData(NaukriDTO naukri) throws IOException {

		ModelAndView mav = new ModelAndView();
		mav.addObject("CandidateDetails", naukri);
		mav.setViewName("naukri.jsp");
		return mav;
	}

	@RequestMapping("/fileUpload")
	public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		String type = file.getContentType();
		String fname = file.getName();
		Long size = file.getSize();
		// String storedFilePath =
		// "C:\\\\Users\\\\Dell\\\\Desktop\\\\STSProjects\\\\SpringBootInitialPractice\\\\src\\\\main\\\\resources\\\\static\\\\CVs";
		String storedFilePath = new ClassPathResource("static/CVs/").getFile().getAbsolutePath();
		Files.copy(file.getInputStream(), Paths.get(storedFilePath + File.separator + fileName),
				StandardCopyOption.REPLACE_EXISTING);
		System.out.println(type + " " + fname + " " + size);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));

	}

}
