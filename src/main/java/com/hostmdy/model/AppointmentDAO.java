package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class AppointmentDAO {
	private DataSource datasource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public AppointmentDAO() {
		
	}
	
	
	public AppointmentDAO(DataSource datasource) {
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
	
	public List<Appointment> getAppointmentList(){
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		try {
			connection = datasource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from appointment;");
			
			while(rs.next()) {
				appointmentList.add(new Appointment(
						rs.getInt("idappointment"),
						rs.getString("name"),
						rs.getString("doc_name"),
						rs.getString("pt_contact"),
						rs.getString("date"),
						rs.getString("message")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return appointmentList;
		
	}
	
	public Appointment getAppointmentById(int idappointment) {
		Appointment appointment = null;
		try {
			connection = datasource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from appointment where idappointment = '"+idappointment+"';");
			
			while(rs.next()) {
				appointment = new Appointment(
						rs.getInt("idappointment"),
						 rs.getString("name"),
						 rs.getString("doc_name"),
						 rs.getString("pt_contact"),
						 rs.getString("date"),
						 rs.getString("message"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return appointment;
		
	}
	
	public List<Appointment> getAppointmentListByName(String name){
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		try {
			connection = datasource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from appointment where name = '"+name+"';");
			
			while(rs.next()) {
				appointmentList.add(new Appointment(
						rs.getInt("idappointment"),
						rs.getString("name"),
						rs.getString("doc_name"),
						rs.getString("pt_contact"),
						rs.getString("date"),
						rs.getString("message")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return appointmentList;
		
	}
	
	
	//insert appointment
		public int createAppointment(Appointment appointment) {
			int rowEffected = 0;
			try {
				connection = datasource.getConnection();
				pStmt = connection.prepareStatement(
						"INSERT INTO `appointment` "
						+ "(`name`, `doc_name`, `pt_contact`, `date`, `message`)"
						+ " VALUES (?, ?, ?, ?, ?);");
				
				pStmt.setString(1, appointment.getName());
				pStmt.setString(2, appointment.getDoc_name());
				pStmt.setString(3, appointment.getPt_contact());
				pStmt.setString(4, appointment.getDate());
				pStmt.setString(5, appointment.getMessage());
				
				rowEffected = pStmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close();
			}
			return rowEffected;
		}
		
		//update appointment
		public int updateAppointment(Appointment appointment) {
			int rowEffected = 0;
			try {
				connection = datasource.getConnection();
				pStmt = connection.prepareStatement(""
						+ "UPDATE `appointment` SET "
						+ "`name` = ?, "
						+ "`doc_name` = ?, "
						+ "`pt_contact` = ?, "
						+ "`date` = ?, "
						+ "`message` = ?  WHERE (`idappointment` = ?);"
						
						);
				
			pStmt.setString(1, appointment.getName());
			pStmt.setString(2, appointment.getDoc_name());
			pStmt.setString(3, appointment.getPt_contact());
			pStmt.setString(4, appointment.getDate());
			pStmt.setString(5, appointment.getMessage());
			pStmt.setInt(6, appointment.getIdappointment());
			
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
		public int deleteAppointment(int idappointment) {
			int rowEffected = 0;
			try {
				connection = datasource.getConnection();
				pStmt = connection.prepareStatement("delete from appointment where idappointment = ?;");
				pStmt.setInt(1,idappointment);
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
