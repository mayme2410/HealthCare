package com.hostmdy.model;

public class Appointment {
	private int idappointment;
	private String name;
	private String doc_name;
	private String pt_contact;
	private String date;
	private String message;
	
	public Appointment(){
		
	}
	
	public int getIdappointment() {
		return idappointment;
	}

	public void setIdappointment(int idappointment) {
		this.idappointment = idappointment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getPt_contact() {
		return pt_contact;
	}

	public void setPt_contact(String pt_contact) {
		this.pt_contact = pt_contact;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public Appointment(int idappointment, String name, String doc_name, String pt_contact, String date,
			String message) {
		super();
		this.idappointment = idappointment;
		this.name = name;
		this.doc_name = doc_name;
		this.pt_contact = pt_contact;
		this.date = date;
		this.message = message;
	}

	public Appointment(String name, String doc_name, String pt_contact, String date, String message) {
		super();
		this.name = name;
		this.doc_name = doc_name;
		this.pt_contact = pt_contact;
		this.date = date;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Appointment [idappointment=" + idappointment + ", name=" + name + ", doc_name=" + doc_name
				+ ", pt_contact=" + pt_contact + ", date=" + date + ", message=" + message + "]";
	}

	
	
	
}
