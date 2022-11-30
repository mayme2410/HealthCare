package com.hostmdy.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.crypto.PasswordEncoder;
import com.hostmdy.crypto.PasswordValidator;



public class PatientDAO {
private DataSource datasource;
private Connection connection;
private Statement stmt;
private PreparedStatement pStmt;
private ResultSet rs;

public PatientDAO(DataSource datasource) {
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


public List<Patient> getPatientList(){
	List<Patient> patientList = new ArrayList<Patient>();
	try {
		connection = datasource.getConnection();
		stmt = connection.createStatement();
		rs = stmt.executeQuery("select * from patient;");
		
		while(rs.next()) {
			 patientList.add(new Patient(
					 rs.getInt("idpatient"),
					 rs.getString("name"),
					 rs.getString("contact"),
					 rs.getString("dateofbirth"),
					 rs.getString("address"),
					 rs.getString("username"),
					 rs.getString("email"),
					 rs.getString("password")));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}
	
	return patientList;
	
}

public Patient getPatientById(int idpatient) {
	Patient patient = null;
	try {
		connection = datasource.getConnection();
		stmt = connection.createStatement();
		rs = stmt.executeQuery("select * from patient where idpatient = '"+idpatient+"';");
		
		while(rs.next()) {
			patient = new Patient(
					rs.getInt("idpatient"),
					 rs.getString("name"),
					 rs.getString("contact"),
					 rs.getString("dateofbirth"),
					 rs.getString("address"),
					 rs.getString("username"),
					 rs.getString("email"),
					 rs.getString("password"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}
	return patient;
	
}

public String getPasswordById(int idpatient) {
	String password = null;
	try {
		connection = datasource.getConnection();
		stmt = connection.createStatement();
		rs = stmt.executeQuery("select password from patient where idpatient = '"+idpatient+"';");
		
		while(rs.next()) {
			password = rs.getString("password");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}
	return password;
	
}

public String getEmailById(int idpatient) {
	String email = null;
	try {
		connection = datasource.getConnection();
		stmt = connection.createStatement();
		rs = stmt.executeQuery("select email from patient where idpatient = '"+idpatient+"';");
		
		while(rs.next()) {
			email = rs.getString("email");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}
	return email;
	
}

//insert patient
public int createPatient(Patient patient) {
	int rowEffected = 0;
	try {
		connection = datasource.getConnection();
		pStmt = connection.prepareStatement(
				"INSERT INTO `patient` ("
				+ "`name`, `contact`, `dateofbirth`, `address`, `username`, `email`, `password`)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?);");
		pStmt.setString(1, patient.getName());
		pStmt.setString(2, patient.getContact());
		pStmt.setString(3, patient.getDateofbirth());
		pStmt.setString(4, patient.getAddress());
		pStmt.setString(5, patient.getUsername());
		pStmt.setString(6, patient.getEmail());
		//pStmt.setString(7, patient.getPassword());
		String securedPassword = null;
		try {
			securedPassword = PasswordEncoder.encode(patient.getPassword());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pStmt.setString(7, securedPassword);
		rowEffected = pStmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}
	return rowEffected;
}

//update patient
public int updatePatient(Patient patient) {
	int rowEffected = 0;
	try {
		connection = datasource.getConnection();
		pStmt = connection.prepareStatement(""
				+ "UPDATE `patient` SET "
				+ "`name` = ?, "
				+ "`contact` = ?, "
				+ "`dateofbirth` = ?, "
				+ "`address` = ?, "
				+ "`email` = ?,"
				+ "`password` = ?  WHERE (`idpatient` = ?);"
				
				);
		
	pStmt.setString(1, patient.getName());
	pStmt.setString(2, patient.getContact());
	pStmt.setString(3, patient.getDateofbirth());
	pStmt.setString(4, patient.getAddress());
	pStmt.setString(5, patient.getEmail());
	pStmt.setString(6, patient.getPassword());
	pStmt.setInt(7, patient.getIdpatient());
	
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
public int deletePatient(int idpatient) {
	int rowEffected = 0;
	try {
		connection = datasource.getConnection();
		pStmt = connection.prepareStatement("delete from patient where idpatient = ?;");
		pStmt.setInt(1,idpatient);
		rowEffected = pStmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}
	return rowEffected;
}

public boolean isValidPatient(String email, String originalPassword) {
	Patient patient = getPatientByEmail(email);
	boolean valid = false;
	
	
	if(patient != null) {
		String storedPassword = patient.getPassword();
		try {
			valid = PasswordValidator.validatePassword(originalPassword, storedPassword);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return valid;
}

public Patient getPatientByEmail(String email) {
	Patient patient = null;
	try {
		connection = datasource.getConnection();
		stmt = connection.createStatement();
		rs = stmt.executeQuery("select * from patient where email='"+email+"';");
		
		while(rs.next()) {
			patient = new Patient(
					rs.getInt("idpatient"),
					 rs.getString("name"),
					 rs.getString("contact"),
					 rs.getString("dateofbirth"),
					 rs.getString("address"),
					 rs.getString("username"),
					 rs.getString("email"),
					 rs.getString("password"));
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}
	return patient;
}

}
