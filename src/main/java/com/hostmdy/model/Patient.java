package com.hostmdy.model;

public class Patient {
private int idpatient;
private String name;
private String contact;
private String dateofbirth;
private String address;
private String username;
private String email;
private String password;


public Patient() {
	
}


public Patient(String name, String contact, String dateofbirth, String address, 
		String username, String email, String password) {
	super();
	this.name = name;
	this.contact = contact;
	this.dateofbirth = dateofbirth;
	this.address = address;
	this.username = username;
	this.email = email;
	this.password = password;
}


public Patient(int idpatient, String name, String contact, String dateofbirth, String address,
		String username, String email, String password) {
	super();
	this.idpatient = idpatient;
	this.name = name;
	this.contact = contact;
	this.dateofbirth = dateofbirth;
	this.address = address;
	this.username = username;
	this.email = email;
	this.password = password;
}


public int getIdpatient() {
	return idpatient;
}


public void setIdpatient(int idpatient) {
	this.idpatient = idpatient;
}

public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getContact() {
	return contact;
}


public void setContact(String contact) {
	this.contact = contact;
}


public String getDateofbirth() {
	return dateofbirth;
}


public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
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
	return "Patient [idpatient=" + idpatient + ", name=" + name + ", contact=" + contact + ", dateofbirth="
			+ dateofbirth + ", address=" + address + ", username=" + username + ", email=" + email + ", password="
			+ password + "]";
}






}
