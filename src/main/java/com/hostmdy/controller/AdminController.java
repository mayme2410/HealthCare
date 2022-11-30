package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import javax.sql.DataSource;

import com.hostmdy.model.Admin;
import com.hostmdy.model.AdminDAO;
import com.hostmdy.model.Patient;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name="jdbc/healthCareSystem")
	private DataSource datasource;
	private AdminDAO adminDAO;
	
	@Override
	public void init() throws ServletException {
		adminDAO = new AdminDAO(datasource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "SIGNUP";
		}
		switch (mode) {
		case "SIGNUP": 
			signup(request, response);
			break;
		
		
		default:
			signup(request, response);
			break;
		}
		
	}

	private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		Admin admin = new Admin(username, email, password);
		
		int rowEffected = this.adminDAO.createAdmin(admin);
		if(rowEffected > 0) {
			response.sendRedirect("adminlogin");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
