package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Login;
@Service
public interface LoginService {
	
	public boolean isValidate(Login login);

}
