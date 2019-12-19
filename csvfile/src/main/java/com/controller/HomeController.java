package com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.csv.Employee;
import com.csv.UploadFile;
import com.dao.FileUploadDao;



/**
 * Handles requests for the file upload page.
 */
@Controller
public class HomeController {
	@Autowired
	private FileUploadDao fileUploadDao;

	@RequestMapping("/say")
	public String sayHello() {
		return "Hello";
	}
	@RequestMapping(value = "/")
	public String showUploadForm(HttpServletRequest request) {
		return "Upload";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public  String handleFileUpload(HttpServletRequest request,
			@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload){
				String env;
				String folderName="D:/temp";			
				Path directory=Paths.get(folderName);
				//directory=directory.toAbsolutePath();
				File f=new File(directory+"/"+aFile.getOriginalFilename());
				aFile.transferTo(f);
				String line = "";  String splitBy = ",";  
				try   
				{ 
					BufferedReader br = new BufferedReader(new FileReader(f));  
				while ((line = br.readLine()) != null)     
				{  String[] employee = line.split(splitBy);
				System.out.println("loading");

				System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] );//+ ", Salary= " + employee[4] ) ;  
				Employee em =new Employee();
				em.setFirstname(employee[0]);
				em.setLastname(employee[1]);
				em.setDesignation(employee[2]);
				em.setContact(employee[3]);
				em.setDate(new Date());
				fileUploadDao.savee(em);
				
				
				}
				} catch(Exception e)
				{
					System.err.println("Problem : "+e);
				}

				
				
				  System.out.println("Saving file: " + aFile.getOriginalFilename());
				  
				/*
				 * UploadFile uploadFile = new UploadFile();
				 * uploadFile.setFileName(aFile.getOriginalFilename());
				 * uploadFile.setData(aFile.getBytes()); uploadFile.setDate(new Date());
				 * fileUploadDao.save(uploadFile);
				 */
			}
		}

		return "Success";
	}  
}