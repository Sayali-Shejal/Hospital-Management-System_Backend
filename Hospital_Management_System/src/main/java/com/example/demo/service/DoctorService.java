package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DoctorModel;
import com.example.demo.repository.DoctorRepository;

@Service("DrService")
public class DoctorService {
	@Autowired
	private DoctorRepository DrRepo;

	public boolean isAddNewDoctor(DoctorModel doctor) {
		return DrRepo.isAddNewDoctor(doctor);
	}
	public List<DoctorModel> getAllDoctor(){
		return DrRepo.getAllDoctor();
		
	}
	public DoctorModel getDoctorById(int id) {
		return DrRepo.getDoctorById(id);
		
	}
	
	public boolean  DeleteDoctorById(int id) {
		return DrRepo.DeleteDoctorById(id);
		
	}
	
	public boolean isUpdateDoctor(DoctorModel doctor) {
		return DrRepo.isUpdateDoctor(doctor);
	}

}
