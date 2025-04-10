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
import com.example.demo.model.DoctorModel;
import com.example.demo.service.DoctorService;

@RestController

public class DoctorController {
	@Autowired
	DoctorService DrService;
	@PostMapping("/AddDoctor")
	public String AddDoctor(@RequestBody DoctorModel doctor) {
		boolean b=DrService.isAddNewDoctor(doctor);
		if(b) {
			return " Doctor Added Successfully....";
		}
		else {
			return "Doctor Not Added";
		}
		
	}
	
	@GetMapping("/viewAllDoctor")
	public List<DoctorModel> getAllDoctor(){
		List<DoctorModel> list=DrService.getAllDoctor();
		if(list.size()!=0) {
			return list;
		}
		else {
			throw new NotFoundException("There is no data in databse");
		}
		
	}
	@GetMapping("/searchDoctorById/{Dr_id}")
	public  DoctorModel searchDoctorById(@PathVariable("Dr_id")Integer id) {
		DoctorModel dr=DrService.getDoctorById(id);
		if(dr!=null) {
			return dr;
		}
		else {
			throw new NotFoundException("Doctor not Found Using "+id);
		}
		
	}
	
	@GetMapping("/deleteDById/{DR_ID}")
	public String deleteDoctorById(@PathVariable("DR_ID") Integer id) {
		boolean b=DrService.DeleteDoctorById(id);
		if(b) {
			return "Doctor  Deleted";
		}
		else {
			throw new NotFoundException("Doctor Not found using id " + id);

		}
		//return null;
		
	}
	@PutMapping("/updateDoctor")
	public String updateDoctor(@RequestBody DoctorModel doctor) {
		boolean b=DrService.isUpdateDoctor(doctor);
		if(b) {
			return "Doctor Record update with id"+doctor;
		}
		else {
			throw new NotFoundException("Doctor Not found using id " + doctor.getId());

		}
		
	}
}
