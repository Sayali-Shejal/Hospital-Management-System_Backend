package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorModel {
    private int id;
    private String name;
   // private Long mobileNo;
    private Long mobileNo;  // Wrapper class Long (allows null values)
    private String email;
    private String gender;
    private int age;
    private int experience;
    private Integer spId; 
    @JsonProperty("password")

    private String password;

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DoctorModel [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", email=" + email + ", gender="
				+ gender + ", age=" + age + ", experience=" + experience + ", spId=" + spId + ", password=" + password
				+ ", getPassword()=" + getPassword() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getMobileNo()=" + getMobileNo() + ", getEmail()=" + getEmail() + ", getGender()=" + getGender()
				+ ", getAge()=" + getAge() + ", getExperience()=" + getExperience() + ", getSpId()=" + getSpId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Integer getSpId() {  // Fixed method name
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }
}
