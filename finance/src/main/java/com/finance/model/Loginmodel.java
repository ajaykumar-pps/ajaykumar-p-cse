package com.finance.model;

public class Loginmodel {
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	
	public Loginmodel(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	
	


}
