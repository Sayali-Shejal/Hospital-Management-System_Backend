package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.AdminModel;
import com.example.demo.model.DoctorModel;
import com.example.demo.service.AdminService;

import jakarta.annotation.PostConstruct;


@RestController
public class AdminController {
	@Autowired
	AdminService ADService;
	@PostMapping("/AdminAdd")
	public String AddAdmin(@RequestBody AdminModel admin) {
		
		boolean b=ADService.isAddNewAdmin(admin);
		if(b) {
			return "Admin Added Successfullyy...!";
		}
		else {
			return "Admin Not Added ...!";
		}
		
		
	}
	@GetMapping("/viewAllAdmin")
	public List<AdminModel> getAllAdmin(){
		List<AdminModel> list=ADService.getAllAdmin();
		if(list.size()!=0) {
			return list;
		}
		else {
			throw new NotFoundException("There is no data in databse");
		}
		
	}
	
	@GetMapping("/searchAdminById/{Ad_ID}")
	public AdminModel searchAdminById(@PathVariable("Ad_ID")Integer id ) {
		AdminModel am=ADService.getAdminById(id);
		if(am!=null) {
			return am;
		}
		else {
			throw new NotFoundException("Admin not Found Using "+id);
		}
		
	}
	
	@GetMapping("/deleteAdById/{Ad_ID}")
	public String deletePatientById(@PathVariable("Ad_ID") Integer id) {
		boolean b=ADService.DeleteAdminById(id);
		if(b) {
			return "Admin Deleted";
		}
		else {
			throw new NotFoundException("Admin Not found using id " + id);

		}
		//return null;
		
	}  
	
	@PutMapping("/updateAdmin")
	public String UpdateAdmin(@RequestBody AdminModel admin) {
		System.out.println(admin);
		boolean b=ADService.isUpdateAdmin(admin);
		if(b) {
			return "Admin Record update with id"+admin;
		}
		
		else {
			throw new NotFoundException("Admin Not found using id " + admin.getAd_Id());

		}
		
	}
}
