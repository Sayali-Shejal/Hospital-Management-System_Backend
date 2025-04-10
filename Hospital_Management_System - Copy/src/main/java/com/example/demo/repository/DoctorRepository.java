package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DoctorModel;
import com.example.demo.model.Login;

@Repository("DrRepo")
public class DoctorRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	List<DoctorModel> list;
	/*
	 * public boolean isAddNewDoctor(DoctorModel doctor) {
	 * System.out.println("========================	"+doctor); int
	 * val=jdbcTemplate.update("insert into Doctor values('0',?,?,?,?,?,?,?)",new
	 * PreparedStatementSetter() {
	 * 
	 * @Override public void setValues(PreparedStatement ps) throws SQLException {
	 * ps.setString(1, doctor.getName()); ps.setLong(2,doctor.getMobileNo());
	 * ps.setString(3, doctor.getEmail()); ps.setString(4, doctor.getGender());
	 * ps.setLong(5, doctor.getAge()); ps.setLong(6, doctor.getExperience());
	 * ps.setLong(7,doctor.getSpId());
	 * 
	 * }
	 * 
	 * }); return val>0?true:false;
	 * 
	 * }
	 */
	public boolean isAddNewDoctor(DoctorModel doctor) {
       System.out.println("======================== " + doctor);

        String sql = "INSERT INTO Doctor (Dr_name, Mobile_no, Email_id, Gender, Age, Experience, Sp_Id,password) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        int val = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, doctor.getName());

                // Allow NULL values safely
                if (doctor.getMobileNo() != null) {
                    ps.setLong(2, doctor.getMobileNo());
                } else {
                    ps.setNull(2, java.sql.Types.BIGINT);
                }

                ps.setString(3, doctor.getEmail());
                ps.setString(4, doctor.getGender());

                if (doctor.getAge() != 0) {
                    ps.setInt(5, doctor.getAge());
                } else {
                    ps.setNull(5, java.sql.Types.INTEGER);
                }

                if (doctor.getExperience() != 0) {
                    ps.setInt(6, doctor.getExperience());
                } else {
                    ps.setNull(6, java.sql.Types.INTEGER);
                }

                if (doctor.getSpId() != null) {
                    ps.setInt(7, doctor.getSpId());
                } else {
                    ps.setNull(7, java.sql.Types.INTEGER);
                }
                
                ps.setString(8, doctor.getPassword());
                
            }
        });

        return val>0?true:false;
    }
	public List<DoctorModel> getAllDoctor(){
		 list=jdbcTemplate.query("select * from Doctor", new RowMapper<DoctorModel>() {

			@Override
			public DoctorModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				 DoctorModel doctor = new DoctorModel();
		           doctor.setId(rs.getInt(1));
		            doctor.setName(rs.getString(2));
		            
		            // Handle potential incorrect data for mobile number
		            try {
		                doctor.setMobileNo(rs.getLong(3));
		            } catch (SQLException e) {
		                doctor.setMobileNo(null); // Set to null if invalid
		                System.err.println("Invalid mobile number found in database: " + e.getMessage());
		            }
		            
		            doctor.setEmail(rs.getString(4));
		            doctor.setGender(rs.getString(5));
		            doctor.setAge(rs.getInt(6));
		            doctor.setExperience(rs.getInt(7));
		            doctor.setSpId(rs.getInt(8));
		            doctor.setPassword(rs.getString(9));
		            return doctor;
			}
		 });
      return list;
		
	}
	
	public DoctorModel getDoctorById(int id) {
		//list=jdbcTemplate.query("select", null)
		 list=jdbcTemplate.query("select * from Doctor where  DR_ID=?",new Object[] {id}, new RowMapper<DoctorModel>() {

				@Override
				public DoctorModel mapRow(ResultSet rs, int rowNum) throws SQLException {
					 DoctorModel doctor = new DoctorModel();
			           doctor.setId(rs.getInt(1));
			            doctor.setName(rs.getString(2));
			            
			            // Handle potential incorrect data for mobile number
			            try {
			                doctor.setMobileNo(rs.getLong(3));
			            } catch (SQLException e) {
			                doctor.setMobileNo(null); // Set to null if invalid
			                System.err.println("Invalid mobile number found in database: " + e.getMessage());
			            }
			            
			            doctor.setEmail(rs.getString(4));
			            doctor.setGender(rs.getString(5));
			            doctor.setAge(rs.getInt(6));
			            doctor.setExperience(rs.getInt(7));
			            doctor.setSpId(rs.getInt(8));
			            doctor.setPassword(rs.getString(9));
			            return doctor;
				}
			 });
	      return list.size()>0?list.get(0):null;
		
		
	}
	public boolean  DeleteDoctorById(int id) {
		int val=jdbcTemplate.update("delete from Doctor  where DR_ID= "+id);
		
		return val>0?true:false;
		
	}
	public boolean isUpdateDoctor(DoctorModel doctor) {
		 int val =jdbcTemplate.update("update Doctor set Dr_name=? ,Mobile_no=?, Email_id=? ,Gender=?,Age=?,Experience=?, Sp_Id=?,  password=?  where DR_ID=? ",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, doctor.getName());
				ps.setLong(2, doctor.getMobileNo());
				ps.setString(3, doctor.getEmail());
				ps.setString(4, doctor.getGender());
				ps.setInt(5,doctor.getAge());
				ps.setInt(6, doctor.getExperience());
				ps.setInt(7, doctor.getSpId());
				ps.setString(8, doctor.getPassword());
				ps.setInt(9,  doctor.getId());
			}
		 });
		return false;
		
	}
	public boolean isValidate(Login login) {
		// TODO Auto-generated method stub

		//System.out.println("Email:"+login.getEmail()+" Password:"+login.getPass()+" Role:"+login.getRole());
      String sql = "SELECT count(*) FROM Doctor WHERE Email =? AND Password =?";
	    
	    int val = jdbcTemplate.queryForObject(
	        sql,
	        new Object[] { login.getEmail(), login.getPass() },
	        Integer.class
	    );


		return val>0? true :false;

	}
}
