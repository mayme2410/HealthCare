package com.hostmdy.model;

public class Doctor {
	private int iddoctor;
	private String doc_name;
	private String work_exp;
	private String degree;
	private String fees;
	private String specialization;
	
	public Doctor() {
		
	}

	public Doctor(String doc_name, String work_exp, String degree, String fees, String specialization) {
		super();
		this.doc_name = doc_name;
		this.work_exp = work_exp;
		this.degree = degree;
		this.fees = fees;
		this.specialization = specialization;
	}

	public Doctor(int iddoctor, String doc_name, String work_exp, String degree, String fees, String specialization) {
		super();
		this.iddoctor = iddoctor;
		this.doc_name = doc_name;
		this.work_exp = work_exp;
		this.degree = degree;
		this.fees = fees;
		this.specialization = specialization;
	}

	public int getIddoctor() {
		return iddoctor;
	}

	public void setIddoctor(int iddoctor) {
		this.iddoctor = iddoctor;
	}

	

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getWork_exp() {
		return work_exp;
	}

	public void setWork_exp(String work_exp) {
		this.work_exp = work_exp;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor [iddoctor=" + iddoctor + ", doc_name=" + doc_name + ", work_exp=" + work_exp + ", degree=" + degree
				+ ", fees=" + fees + ", specialization=" + specialization + "]";
	}
	
}
