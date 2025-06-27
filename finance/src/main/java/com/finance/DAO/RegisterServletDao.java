package com.finance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.finance.model.Register;

public class RegisterServletDao {
	private Connection con;
	
	public RegisterServletDao(Connection con){
		this.con=con;
		
	}
	public boolean isRegisterExists(String email,String username )throws SQLException{
		String sql="SELECT * FROM users WHERE email=? OR username=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, username);
		ResultSet rs=ps.executeQuery();
		return rs.next();
	}
	public boolean registerRegister(Register reg)throws SQLException{
		String sql="INSERT INTO users(name,email,username,password) VALUES(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, reg.getName());
		ps.setString(2, reg.getEmail());
		ps.setString(3, reg.getUsername());
		ps.setString(4, reg.getPassword());
		
		return ps.executeUpdate()>0;
	
		
		
	}

}
