package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AppointmentModel;
@Repository("ApRepo")
public class AppointmentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	List<AppointmentModel> list;

	public boolean isAddNewAppointment(AppointmentModel appointment) {
		String sql = "INSERT INTO appointment (Name, DOB, Age, Gender, Mobile_No, Email, Address, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		//String sql = "insert into appointment (Name, DOB, Age, Gender, Mobile_No, Email, Address, password) VALUES ('0',?,?,?,?,?,?,?,?)";

        int val = jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(4, appointment.getCancel_confirm());
				ps.setString(5, appointment.getPassword());

			}
              
       });
		return val>0?true:false;


	}

	public List<AppointmentModel> getAllAppointment() {
		// TODO Auto-generated method stub
		return null;
	}

	public AppointmentModel getAppointmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean DeleteAppointmentById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUpdateAppointment(AppointmentModel admin) {
		// TODO Auto-generated method stub
		return false;
	}

}
