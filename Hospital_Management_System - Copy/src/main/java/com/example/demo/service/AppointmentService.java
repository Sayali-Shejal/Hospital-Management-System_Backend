package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AppointmentModel;
import com.example.demo.repository.AppointmentRepository;

@Service("ApService")
public class AppointmentService {
	@Autowired
	private  AppointmentRepository ApRepo;
	

	public boolean isAddNewAppointment(AppointmentModel appointment) {
		return ApRepo.isAddNewAppointment(appointment);
	}
	public List<AppointmentModel> getAllAppointment(){
		return ApRepo.getAllAppointment();
		
	}
	public AppointmentModel getAppointmentById(int id) {
		return ApRepo.getAppointmentById(id);
		
	}
	
	public boolean  DeleteAppointmentById(int id) {
		return ApRepo.DeleteAppointmentById(id);
		
	}
	
	public boolean isUpdateAdmin(AppointmentModel admin) {
		return ApRepo.isUpdateAppointment(admin);
	}


}
