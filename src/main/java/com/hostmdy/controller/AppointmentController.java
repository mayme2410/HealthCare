package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Appointment;
import com.hostmdy.model.AppointmentDAO;
import com.hostmdy.model.Doctor;
import com.hostmdy.model.DoctorDAO;
import com.hostmdy.model.Patient;
import com.hostmdy.model.PatientDAO;

/**
 * Servlet implementation class AppointmentController
 */
public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/healthCareSystem")
	private DataSource datasource;
	private DoctorDAO doctorDAO;
	private PatientDAO patientDAO;
	private AppointmentDAO appointmentDAO;
	
	@Override
	public void init() throws ServletException {
		doctorDAO = new DoctorDAO(datasource);
		patientDAO = new PatientDAO(datasource);
		appointmentDAO = new AppointmentDAO(datasource);
	}
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "LIST";
		}
		switch (mode) {
		case "LIST":
			showDoctorList(request,response);
			break;
			
		case "CREATE":
			createAppointment(request,response);
			break;
			
//		case "VIEW":
//			viewAppointment(request,response);
//			break;
			
		default:
			showDoctorList(request, response);
			break;
		
		}
	}

//	private void viewAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		List<Appointment> appointmentList = this.appointmentDAO.getAppointmentList();
//		request.setAttribute("appointmentList", appointmentList);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("appointment-list.jsp");
//		rd.forward(request, response);
//	}



	private void createAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				String name = request.getParameter("pt_name");
				String doc_name = request.getParameter("doc_name");
				String pt_contact = request.getParameter("pt_contact");
				String date = request.getParameter("appointment_date");
				String message = request.getParameter("message");
				
				Appointment appointment = new Appointment(name, doc_name, pt_contact, date, message);
				
				int rowEffected = this.appointmentDAO.createAppointment(appointment);
				if(rowEffected > 0) {
					registerAppointment(request, response);
				}
	}



	private void registerAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean appointmentRegister = true;
		request.setAttribute("appointmentRegister", appointmentRegister);
		RequestDispatcher rd = request.getRequestDispatcher("appointmentshow");
		rd.forward(request, response);
	}



	private void showDoctorList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Doctor> doctorList = this.doctorDAO.getDoctorList();
		request.setAttribute("doctorList", doctorList);
		
		List<Patient> patientList = this.patientDAO.getPatientList();
		request.setAttribute("patientList", patientList);
		
		RequestDispatcher rd = request.getRequestDispatcher("appointment-register.jsp");
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
