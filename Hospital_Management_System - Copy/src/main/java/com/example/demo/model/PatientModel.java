package com.example.demo.model;
//
//import java.sql.Date;
//
//public class PatientModel {
//	private int P_id;
//	private String Name;
//	private Date DOB;
//	
//	public int getP_id() {
//		return P_id;
//	}
//	public void setP_id(int p_id) {
//		P_id = p_id;
//	}
//	public String getName() {
//		return Name;
//	}
//	public void setName(String name) {
//		Name = name;
//	}
//	public Date getDOB() {
//		return DOB;
//	}
//	public void setDOB(Date dOB) {
//		DOB = dOB;
//	}
//	public int getAge() {
//		return Age;
//	}
//	public void setAge(int age) {
//		Age = age;
//	}
//	public String getGender() {
//		return Gender;
//	}
//	public void setGender(String gender) {
//		Gender = gender;
//	}
//	public String getBlood_Group() {
//		return Blood_Group;
//	}
//	public void setBlood_Group(String blood_Group) {
//		Blood_Group = blood_Group;
//	}
//	public long getMobile_No() {
//		return Mobile_No;
//	}
//	public void setMobile_No(long mobile_No) {
//		Mobile_No = mobile_No;
//	}
//	public String getEmail() {
//		return Email;
//	}
//	public void setEmail(String email) {
//		Email = email;
//	}
//	public String getAddress() {
//		return Address;
//	}
//	public void setAddress(String address) {
//		Address = address;
//	}
//	public String getPassword() {
//		return Password;
//	}
//	public void setPassword(String password) {
//		Password = password;
//	}
//	private int Age;
//	private String Gender;
//	private String Blood_Group;
//	private long Mobile_No;
//	private String Email;
//	private String Address;
//	private String Password;
//	
//
//}
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientModel {
    private int P_Id;
    @JsonProperty("Name")
    private String Name;
    private Date DOB;
    private Integer Age;
    @JsonProperty("gender")
    private String Gender;
    @JsonProperty("Blood_Group")
    private String Blood_Group;
    @JsonProperty("Mobile_No")
    private String Mobile_No;  // Stored as String as per DB schema
    private String Email;
    private String Address;
    @JsonProperty("password")
    private String Password;

    // Default Constructor
    public PatientModel() {
    }

    // Parameterized Constructor
    public PatientModel(int P_Id, String Name, Date DOB, Integer Age, String Gender, String Blood_Group, String Mobile_No, String Email, String Address, String Password) {
        this.P_Id = P_Id;
        this.Name = Name;
        this.DOB = DOB;
        this.Age = Age;
        this.Gender = Gender;
        this.Blood_Group = Blood_Group;
        this.Mobile_No = Mobile_No;
        this.Email = Email;
        this.Address = Address;
        this.Password = Password;
    }

    // Getters and Setters
    public int getP_Id() {
        return P_Id;
    }

    public void setP_Id(int P_Id) {
        this.P_Id = P_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getBlood_Group() {
        return Blood_Group;
    }

    public void setBlood_Group(String Blood_Group) {
        this.Blood_Group = Blood_Group;
    }

    public String getMobile_No() {
        return Mobile_No;
    }

    public void setMobile_No(String Mobile_No) {
        this.Mobile_No = Mobile_No;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "P_Id=" + P_Id +
                ", Name='" + Name + '\'' +
                ", DOB=" + DOB +
                ", Age=" + Age +
                ", Gender='" + Gender + '\'' +
                ", Blood_Group='" + Blood_Group + '\'' +
                ", Mobile_No='" + Mobile_No + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
