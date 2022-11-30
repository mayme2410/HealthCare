package com.hostmdy.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.hostmdy.crypto.PasswordEncoder;
import com.hostmdy.crypto.PasswordValidator;



public class AdminDAO {
	private DataSource datasource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public AdminDAO(DataSource datasource) {
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
	
	public Admin getAdminByEmail(String email) {
		Admin admin = null;
		try {
			connection = datasource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from admin where email='"+email+"';");
			
			while(rs.next()) {
				admin = new Admin(
						rs.getInt("idadmin"),
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
		return admin;
		
	}
	
	public boolean isValidAdmin(String email,String originalPassword) {
		Admin admin = getAdminByEmail(email);
		boolean valid = false;
		
		
		if(admin != null) {
			String storedPassword = admin.getPassword();
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
	
	public int createAdmin(Admin admin) {
		int rowEffected = 0;
		try {
			connection = datasource.getConnection();
			pStmt = connection.prepareStatement(
					"INSERT INTO `admin` "
					+ "(`username`, `email`, `password`) "
					+ "VALUES (?, ?, ?);"
					);
			
			pStmt.setString(1, admin.getUsername());
			
			pStmt.setString(2, admin.getEmail());
			
			
			String securedPassword = null;
			try {
				securedPassword = PasswordEncoder.encode(admin.getPassword());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pStmt.setString(3, securedPassword);
			
			
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
