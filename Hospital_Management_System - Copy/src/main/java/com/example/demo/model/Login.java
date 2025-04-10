package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Login {
	
	private String email;
	 @JsonProperty("password")
	private String pass;
	private String role;
	

}
