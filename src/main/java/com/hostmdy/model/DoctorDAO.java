package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DoctorDAO {
	private DataSource datasource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public DoctorDAO() {
		
	}
	
	
	public DoctorDAO(DataSource datasource) {
		super();
		this.datasource = datasource;
	}


	private void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Doctor> getDoctorList(){
		List<Doctor> doctorList = new ArrayList<Doctor>();
		try {
			connection = datasource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from doctor;");
			
			while(rs.next()) {
				 doctorList.add(new Doctor(
						 rs.getInt("iddoctor"),
						 rs.getString("doc_name"),
						 rs.getString("work_exp"),
						 rs.getString("degree"),
						 rs.getString("fees"),
						 rs.getString("specialization")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return doctorList;
		
	}
	
	public Doctor getDoctorById(int iddoctor) {
		Doctor doctor = null;
		try {
			connection = datasource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from doctor where iddoctor = '"+iddoctor+"';");
			
			while(rs.next()) {
				doctor = new Doctor(
						rs.getInt("iddoctor"),
						 rs.getString("doc_name"),
						 rs.getString("work_exp"),
						 rs.getString("degree"),
						 rs.getString("fees"),
						 rs.getString("specialization"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return doctor;
		
	}
	
	//insert doctor
	public int createDoctor(Doctor doctor) {
		int rowEffected = 0;
		try {
			connection = datasource.getConnection();
			pStmt = connection.prepareStatement(
					"INSERT INTO `doctor` "
					+ "(`doc_name`, `work_exp`, `degree`, `fees`, `specialization`)"
					+ " VALUES (?, ?, ?, ?, ?);");
			
			pStmt.setString(1, doctor.getDoc_name());
			pStmt.setString(2, doctor.getWork_exp());
			pStmt.setString(3, doctor.getDegree());
			pStmt.setString(4, doctor.getFees());
			pStmt.setString(5, doctor.getSpecialization());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	
	//update doctor
	public int updateDoctor(Doctor doctor) {
		int rowEffected = 0;
		try {
			connection = datasource.getConnection();
			pStmt = connection.prepareStatement(""
					+ "UPDATE `doctor` SET "
					+ "`doc_name` = ?, "
					+ "`work_exp` = ?, "
					+ "`degree` = ?, "
					+ "`fees` = ?, "
					+ "`specialization` = ?  WHERE (`iddoctor` = ?);"
					
					);
			
		pStmt.setString(1, doctor.getDoc_name());
		pStmt.setString(2, doctor.getWork_exp());
		pStmt.setString(3, doctor.getDegree());
		pStmt.setString(4, doctor.getFees());
		pStmt.setString(5, doctor.getSpecialization());
		pStmt.setInt(6, doctor.getIddoctor());
		
		rowEffected = pStmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	//delete
	public int deleteDoctor(int iddoctor) {
		int rowEffected = 0;
		try {
			connection = datasource.getConnection();
			pStmt = connection.prepareStatement("delete from doctor where iddoctor = ?;");
			pStmt.setInt(1,iddoctor);
			rowEffected = pStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
}
