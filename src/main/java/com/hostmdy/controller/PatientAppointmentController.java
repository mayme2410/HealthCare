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
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Appointment;
import com.hostmdy.model.AppointmentDAO;
import com.hostmdy.model.Doctor;
import com.hostmdy.model.DoctorDAO;
import com.hostmdy.model.Patient;
import com.hostmdy.model.PatientDAO;

/**
 * Servlet implementation class PatientAppointmentController
 */
public class PatientAppointmentController extends HttpServlet {
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
    public PatientAppointmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Patient patient = (Patient) session.getAttribute("patient");
		
		if(patient != null) {
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "LIST";
		}
		switch (mode) {
		case "LIST":
			showAppointmentList(request,response);
			break;
			
		
		default:
			showAppointmentList(request, response);
			break;
		
		}
		}
		else {
			response.sendRedirect("patientlogin");
		}
	}
	private void showAppointmentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = null;
		HttpSession session = request.getSession(false);
		Patient patient = (Patient)session.getAttribute("patient");
		if(patient != null){
		    name = patient.getName();
		}
		
		
		
		List<Appointment> appointmentList = this.appointmentDAO.getAppointmentListByName(name);
		request.setAttribute("appointmentList", appointmentList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("patient-appointment.jsp");
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
