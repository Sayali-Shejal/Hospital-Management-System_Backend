package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.service.AdminService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;

@RestController
public class login_Controller {
	
	@Autowired
	PatientService PtService;
	DoctorService DrService;
	AdminService ADService;
	
	@PostMapping("/login")
	public ResponseEntity<?> isValidate(@RequestBody Login login)
	{
		
		//System.out.println("=======> Email:"+login.getEmail()+" Password:"+login.getPass()+" Role:"+login.getRole());

		boolean b=false;
		String role=login.getRole();
		switch(role)
		{
		case "Admin": 
		
			b=ADService.isValidate(login);
			break;
			
		case "Patient":
		b=PtService.isValidate(login);
			
			break;
			
		case "Doctor":
			b=DrService.isValidate(login);
			break;
		
		}
		
	if(b) {
     return ResponseEntity.ok("Login successful!");

	}else 
	{
		return ResponseEntity.ok("Login Not successful!");

	}
}
	
}
