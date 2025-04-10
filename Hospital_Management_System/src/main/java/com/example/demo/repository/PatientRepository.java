package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PatientModel;

@Repository("PtRepo")

public class PatientRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	List<PatientModel> list;
	
	public boolean isAddNewPatient(PatientModel Patient) {
		  System.out.println("======================== " + Patient);
//	    if (Patient == null || Patient.getName() == null || Patient.getName().trim().isEmpty()) {
//	        System.out.println("Error: Patient Name cannot be null or empty.");
//	        return false;
//	    }

	    String sql = "INSERT INTO  patient (Name, DOB, Age, Gender, Blood_Group, Mobile_No, Email, Address, Password) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    int val = jdbcTemplate.update(sql, new PreparedStatementSetter() {
	        @Override
	        public void setValues(PreparedStatement ps) throws SQLException {
	            ps.setString(1, Patient.getName());

	            ps.setDate(2, Patient.getDOB());

	            if (Patient.getAge() != 0) {
	                ps.setInt(3, Patient.getAge());
	            } else {
	                ps.setNull(3, java.sql.Types.INTEGER);
	            }

	            ps.setString(4, (Patient.getGender() != null) ? Patient.getGender() : "Unknown");
	            ps.setString(5, (Patient.getBlood_Group() != null) ? Patient.getBlood_Group() : "Unknown");
	            ps.setString(6, Patient.getMobile_No());
//	            if (Patient.getMobile_No() != 0) {
//	                ps.setString(6, Patient.getMobile_No());
//	            } else {
//	                ps.setNull(6, java.sql.Types.BIGINT);
//	            }

	            ps.setString(7, (Patient.getEmail() != null) ? Patient.getEmail() : "No Email");
	            ps.setString(8, (Patient.getAddress() != null) ? Patient.getAddress() : "No Address");
	            ps.setString(9, (Patient.getPassword() != null) ? Patient.getPassword() : "defaultPassword");
	        }
	    });

	    return val > 0;
	}

	public List<PatientModel> getAllPatient(){
		 list=jdbcTemplate.query("select * from Patient", new RowMapper<PatientModel>() {

			@Override
			public PatientModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				PatientModel Patient = new PatientModel();
				Patient.setP_Id(rs.getInt(1));
				Patient.setName(rs.getString(2));
				Patient.setDOB(rs.getDate(3));
				Patient.setAge(rs.getInt(4));
				Patient.setGender(rs.getString(5));
				Patient.setBlood_Group(rs.getString(6));
				Patient.setMobile_No(rs.getString(7));	                     
		            
		        Patient.setEmail(rs.getString(8));
		       
		        Patient.setAddress(rs.getNString(9));
		        Patient.setPassword(rs.getString(10));
		            return Patient;
			}
		 });
      return list;
		
	}
	
	public PatientModel getPatientById(int id) {
		//list=jdbcTemplate.query("select", null)
		 list=jdbcTemplate.query("DELETE FROM Patient WHERE P_ID = ?",new Object[] {id}, new RowMapper<PatientModel>() {

				@Override
				public PatientModel mapRow(ResultSet rs, int rowNum) throws SQLException {
					PatientModel Patient = new PatientModel();
					Patient.setP_Id(rs.getInt(1));
					Patient.setName(rs.getString(2));
					Patient.setDOB(rs.getDate(3));
					Patient.setAge(rs.getInt(4));
					Patient.setGender(rs.getString(5));
					Patient.setBlood_Group(rs.getString(6));
					Patient.setMobile_No(rs.getString(7));	                     
			            
			        Patient.setEmail(rs.getString(8));
			       
			        Patient.setAddress(rs.getNString(9));
			        Patient.setPassword(rs.getString(10));
			            return Patient;
				}
			 });
	      return list.size()>0?list.get(0):null;
		
		
	}
	public boolean  DeletePatientById(int id) {
		int val=jdbcTemplate.update("delete from Patient  where P_ID= "+id);
		
		return val>0?true:false;
		
	}
	public boolean isUpdatePatient(PatientModel Patient) {
		System.out.println("data is"+Patient);
		 int val =jdbcTemplate.update("update Patient set Name=?, DOB=?, Age=?, Gender=?, Blood_Group=?, Mobile_No=?, Email=?, Address=?, Password=? WHERE P_ID=?",new PreparedStatementSetter() {

		
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, Patient.getName());

                             
                    ps.setDate(2, Patient.getDOB());
                    if (Patient.getAge() != 0) {
                        ps.setInt(3, Patient.getAge());
                    } else {
                        ps.setNull(3, java.sql.Types.INTEGER);
                    }
                
                
                ps.setString(4, Patient.getGender());

                

                ps.setString(5, Patient.getBlood_Group());
                ps.setString(6, Patient.getMobile_No());

                ps.setString(7, Patient.getEmail());
                
                ps.setNString(8, Patient.getAddress());
                
                ps.setString(9, Patient.getPassword());
                ps.setInt(10, Patient.getP_Id());
			}
		 });
		if(val>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}


}
