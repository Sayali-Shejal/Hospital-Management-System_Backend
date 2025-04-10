package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.PatientModel;
import com.example.demo.service.PatientService;

@RestController
//@CrossOrigin(origins="http://localhost:5173") 
/* @CrossOrigin("*") */
public class PatientController {

	@Autowired
	PatientService PtService;
	
	/*
	 * @PostMapping("/AddPatient") public ResponseEntity<String>
	 * AddPatient(@RequestBody PatientModel Patient) { System.out.println("hello");
	 * if (Patient == null || Patient.getName() == null ||
	 * Patient.getName().trim().isEmpty()) { return
	 * ResponseEntity.badRequest().body("Patient Name cannot be null or empty."); }
	 * 
	 * boolean b = PtService.isAddNewPatient(Patient); if (b) { return
	 * ResponseEntity.ok("Patient Added Successfully."); } else { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Patient Not Added."); } }
	 */
	 @PostMapping("/AddPatient")
	    public ResponseEntity<String> AddPatient(@RequestBody PatientModel Patient) {
		 System.out.println(Patient);
	        System.out.println("hello");
			/*
			 * if (Patient == null || Patient.getName() == null ||
			 * Patient.getName().trim().isEmpty()) { return
			 * ResponseEntity.badRequest().body("Patient Name cannot be null or empty."); }
			 */
	        boolean b = PtService.isAddNewPatient(Patient);
	        if (b) {
	            return ResponseEntity.ok("Patient Added Successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Patient Not Added.");
	        }
	    }

	
	@GetMapping("/viewAllPatient")
	public List<PatientModel> getAllPatient(){
		List<PatientModel> list=PtService.getAllPatient();
		if(list.size()!=0) {
			return list;
		}
		else {
			throw new NotFoundException("There is no data in databse");
		}
		
	}
	@GetMapping("/searchPatientById/{Dr_id}")
	public  PatientModel searchDoctorById(@PathVariable("Dr_id")Integer id) {
		PatientModel dr=PtService.getPatientById(id);
		if(dr!=null) {
			return dr;
		}
		else {
			throw new NotFoundException("Patient not Found Using "+id);
		}
		
	}
	
	@GetMapping("/deletePById/{P_ID}")
	public String deletePatientById(@PathVariable("P_ID") Integer id) {
		boolean b=PtService.DeletePatientById(id);
		if(b) {
			return "Patient Deleted";
		}
		else {
			throw new NotFoundException("Patient Not found using id " + id);

		}
		//return null;
		
	}
	@PutMapping("/updatePatient")
	public String updatePatient(@RequestBody PatientModel patient) {
	    System.out.println("Received Patient Data: " + patient);

	    boolean isUpdated = PtService.isUpdatePatient(patient);
	    if (isUpdated) {
	        return "Patient record updated with ID " + patient.getP_Id();
	    } else {
	        throw new NotFoundException("Patient not found with ID " + patient.getP_Id());
	    }
	}


}
