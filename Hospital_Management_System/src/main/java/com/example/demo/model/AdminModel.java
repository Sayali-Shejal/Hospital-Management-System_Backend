package com.example.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class AdminModel {

    private int Ad_Id;
    private String Name;

    @JsonFormat(pattern = "yyyy-MM-dd") // important for JSON serialization/deserialization
    private LocalDate DOB;

    private int Age;
    private String Gender;
    private String Mobile_No;
    private String Email;
    private String Address;
    private String Password;
}
