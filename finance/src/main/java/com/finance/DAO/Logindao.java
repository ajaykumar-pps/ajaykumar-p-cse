package com.finance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.finance.model.Loginmodel;

public class Logindao {
	private Connection con;
	public Logindao(Connection con) {
		this.con=con;
		
	}
	public boolean validate(Loginmodel loginmodel)throws SQLException{
		String sql="SELECT * FROM users WHERE username=? AND password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,loginmodel.getUsername() );
		ps.setString(2,loginmodel.getPassword());
		ResultSet rs=ps.executeQuery();
		return rs.next();
	}
	
	
}
