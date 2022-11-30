package com.hostmdy.controller;

import jakarta.annotation.Resource;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Patient;
import com.hostmdy.model.PatientDAO;
/**
 * Servlet implementation class PatientController
 */
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name ="jdbc/healthCareSystem")
	private DataSource datasource;
	private PatientDAO patientDAO;
	
	
	@Override
	public void init() throws ServletException {
		patientDAO = new PatientDAO(datasource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "LIST";
		}
		switch (mode) {
		case "LIST":
			showPatientList(request,response);
			break;
			
		case "LOAD": 
			loadPatient(request, response);
			break;
			
		case "CREATE":
			createPatient(request,response);
			break;
			
		case "UPDATE": 
			updatePatient(request, response);
			break;
			
			
		case "DELETE": 
			deletePatient(request, response);
			break;
			
		
			
		default:
			showPatientList(request,response);
			break;
		}
	
		
	}

	

	private void deletePatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idpatient"));
		int rowEffected = this.patientDAO.deletePatient(id);
		
		if(rowEffected > 0) {
			//out.println("Successfully Deleted ID = "+id+" from result table");
			
			showPatientList(request, response);
		}
	}

	private void loadPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idpatient"));
		Patient patient = this.patientDAO.getPatientById(id);
		request.setAttribute("patient", patient);
		RequestDispatcher rd = request.getRequestDispatcher("patient-update.jsp");
		rd.forward(request, response);
		
	}

	private void showPatientList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<Patient> patientList = this.patientDAO.getPatientList();
		PrintWriter out = response.getWriter();
		out.print(patientList + "\n");
		request.setAttribute("patientList", patientList);
		RequestDispatcher rd = request.getRequestDispatcher("patient-list.jsp");
		rd.forward(request, response);
	}

	private void createPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String dateofbirth = request.getParameter("dateofbirth");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Patient patient = new Patient(name, contact, dateofbirth, address, username, email, password);
		
		int rowEffected = this.patientDAO.createPatient(patient);
		if(rowEffected > 0) {
			//registerPatientList(request, response);
			response.sendRedirect("patientlogin");
		}
		
		
	}
	private void updatePatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int idpatient = Integer.parseInt(request.getParameter("idpatient"));
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String dateofbirth = request.getParameter("dateofbirth");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		//String email = request.getParameter("email");
		String email = this.patientDAO.getEmailById(idpatient);
		String password = this.patientDAO.getPasswordById(idpatient);
		//String password = request.getParameter("password");
		
		Patient patient = new Patient(idpatient, name, contact, dateofbirth, address, username, email, password);
		
		int rowEffected = this.patientDAO.updatePatient(patient);
		if(rowEffected > 0) {
			showPatientList(request, response);
		}
	}

	private void registerPatientList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//List<Patient> patientList = this.patientDAO.getPatientList();
		//request.setAttribute("patientList", patientList);
		boolean patientRegister = true;
		request.setAttribute("patientRegister", patientRegister);
		RequestDispatcher rd = request.getRequestDispatcher("patient-register.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
