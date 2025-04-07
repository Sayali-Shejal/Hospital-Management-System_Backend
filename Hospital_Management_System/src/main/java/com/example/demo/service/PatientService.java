package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PatientModel;
import com.example.demo.repository.PatientRepository;

@Service("PtService")

public class PatientService {
	@Autowired
	private PatientRepository PtRepo;

	public boolean isAddNewPatient(PatientModel Patient) {
		//return false;
		return PtRepo.isAddNewPatient(Patient);
	}
	public List<PatientModel> getAllPatient(){
		//return null;
		return PtRepo.getAllPatient();
		
	}
	public PatientModel getPatientById(int id) {
		
		return PtRepo.getPatientById(id);
		
	}
	
	public boolean  DeletePatientById(int id) {
		return PtRepo.DeletePatientById(id);
		//return PtRepo.DeleteDoctorById(id);
		
	}
	
	public boolean isUpdatePatient(PatientModel Patient) {
		//return false;
		return PtRepo.isUpdatePatient(Patient);
	}


}
