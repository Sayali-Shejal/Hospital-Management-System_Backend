package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AdminModel;
import com.example.demo.model.Login;
import com.example.demo.repository.AdminRepository;

@Service("ADService")
public class AdminService {
	

	@Autowired
	private AdminRepository ADRepo;

	public boolean isAddNewAdmin(AdminModel admin) {
		return ADRepo.isAddNewAdmin(admin);
	}
	public List<AdminModel> getAllAdmin(){
		return ADRepo.getAllAdmin();
		
	}
	public AdminModel getAdminById(int id) {
		return ADRepo.getAdminById(id);
		
	}
	
	public boolean  DeleteAdminById(int id) {
		return ADRepo.DeleteAdminById(id);
		
	}
	
	public boolean isUpdateAdmin(AdminModel admin) {
		return ADRepo.isUpdateAdmin(admin);
	}
	public boolean isValidate(Login login) 
	{
		return ADRepo.isValidate(login);
	}	
	

}
