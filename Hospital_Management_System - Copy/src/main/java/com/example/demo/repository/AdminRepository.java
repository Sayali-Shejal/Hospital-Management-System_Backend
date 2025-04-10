package com.example.demo.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminModel;
import com.example.demo.model.Login;
@Repository("ADRepo")
public class AdminRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	List<AdminModel> list;

	public boolean isAddNewAdmin(AdminModel admin) {
		String sql = "INSERT INTO Admin (Name, DOB, Age, Gender, Mobile_No, Email, Address, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		//String sql = "insert into Admin (Name, DOB, Age, Gender, Mobile_No, Email, Address, password) VALUES ('0',?,?,?,?,?,?,?,?)";

        int val = jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, admin.getName());

				if (admin.getDOB() != null) {
				    ps.setDate(2, java.sql.Date.valueOf(admin.getDOB()));
				} else {
				    ps.setNull(2, java.sql.Types.DATE);
				}

				ps.setInt(3, admin.getAge());
				ps.setString(4, admin.getGender());
				ps.setString(5, admin.getMobile_No());
				ps.setString(6, admin.getEmail());
				ps.setString(7, admin.getAddress());
				ps.setString(8, admin.getPassword());

			}
              
       });
		return val>0?true:false;

     }
	

	public List<AdminModel> getAllAdmin() {
		list=jdbcTemplate.query("Select * from Admin", new RowMapper<AdminModel>() {

			@Override
			public AdminModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				 AdminModel admin = new AdminModel();
				    admin.setAd_Id(rs.getInt(1));
				    admin.setName(rs.getString(2));
				    admin.setDOB(rs.getDate(3) != null ? rs.getDate(3).toLocalDate() : null);
				    admin.setAge(rs.getInt(4));
				    admin.setGender(rs.getString(5));
				    admin.setMobile_No(rs.getString(6));
				    admin.setEmail(rs.getString(7));
				    admin.setAddress(rs.getString(8));
				    admin.setPassword(rs.getString(9));

				
				return admin;
			}
			
		});
		
		 return list;
			
	}

	public AdminModel getAdminById(int id) {
		list=jdbcTemplate.query("select * from Admin where  Ad_ID=?",new Object[] {id}, new RowMapper<AdminModel>(){

			@Override
			public AdminModel mapRow(ResultSet rs, int rowNum) throws SQLException {

				AdminModel  admin=new AdminModel();
				admin.setAd_Id(rs.getInt(1));
				admin.setName(rs.getString(2));
//				admin.setDOB(rs.getDate(3));
				admin.setDOB(rs.getDate(3).toLocalDate()); // ✅ convert SQL Date to LocalDate

				admin.setAge(rs.getInt(4));
				admin.setGender(rs.getString(5));
				admin.setMobile_No(rs.getString(6));
				admin.setEmail(rs.getString(7));
				admin.setAddress(rs.getString(8));
				admin.setPassword(rs.getString(9));
				
				return admin;
			}
			
		});
		return list.size()>0?list.get(0):null;
	}

	public boolean DeleteAdminById(int id) {
           int val=jdbcTemplate.update("delete from Admin where Ad_ID= "+id);
		
		return val>0?true:false;
	}

	public boolean isUpdateAdmin(AdminModel admin) {
		System.out.println("+++++++++++++++++"+admin);
		 int val =jdbcTemplate.update("update Admin SET Name=?, DOB=?, Age=?, Gender=?, Mobile_No=?, Email=?, Address=?, password=? WHERE Ad_ID=?",new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, admin.getName());

					if (admin.getDOB() != null) {
					    ps.setDate(2, java.sql.Date.valueOf(admin.getDOB()));
					} else {
					    ps.setNull(2, java.sql.Types.DATE);
					}

					ps.setInt(3,admin.getAge());
					ps.setString(4,admin.getGender());
					ps.setString(5,admin.getMobile_No());
					ps.setString(6,admin.getEmail());
					ps.setString(7, admin.getAddress());
					ps.setString(8, admin.getPassword());
					ps.setInt(9, admin.getAd_Id());

					
					
				}
			 });
		 return val > 0;

	}

	public boolean isValidate(Login login) {
		//System.out.println("Email:"+login.getEmail()+" Password:"+login.getPass()+" Role:"+login.getRole());
	      String sql = "SELECT count(*) FROM Admin WHERE Email =? AND Password =?";
		    
		    int val = jdbcTemplate.queryForObject(
		        sql,
		        new Object[] { login.getEmail(), login.getPass() },
		        Integer.class
		    );


			return val>0? true :false;
	}

}
