package com.hostmdy.model;

public class Admin {
	private int idadmin;
	private String username;
	private String email;
	private String password;
	
	public Admin() {
		
	}
	public Admin(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public Admin(int idadmin, String username, String email, String password) {
		super();
		this.idadmin = idadmin;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public int getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [idadmin=" + idadmin + ", username=" + username + ", email=" + email + ", password=" + password
				+ "]";
	}
	
}
