package com.finance.model;

public class Register {
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	private String email;
	private String username;
	private String password;
	
	public Register(String name, String email,String username,String password){
		this.name=name;
		this.email=email;
		this.username=username;
		this.password=password;
	}

}
