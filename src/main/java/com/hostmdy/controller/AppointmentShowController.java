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
public class AppointmentShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/healthCareSystem")
	private DataSource datasource;
	private AppointmentDAO appointmentDAO;
	private PatientDAO patientDAO;
	private DoctorDAO doctorDAO;
	
	@Override
	public void init() throws ServletException {
		appointmentDAO = new AppointmentDAO(datasource);
		patientDAO = new PatientDAO(datasource);
		doctorDAO = new DoctorDAO(datasource);
	}
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentShowController() {
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
			showAppointmentList(request,response);
			break;
			
		case "LOAD": 
			loadAppointment(request, response);
			break;
			
		case "UPDATE": 
			updateAppointment(request, response);
			break;
		
		case "DELETE": 
			deleteAppointment(request, response);
			break;
			
		default:
			showAppointmentList(request, response);
			break;
		
		}
	}



	private void loadAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idappointment"));
		Appointment appointment = this.appointmentDAO.getAppointmentById(id);
		request.setAttribute("appointment", appointment);
		
		List<Patient> patientList = this.patientDAO.getPatientList();
		request.setAttribute("patientList", patientList);
		
		List<Doctor> doctorList = this.doctorDAO.getDoctorList();
		
		request.setAttribute("doctorList", doctorList);
		
		RequestDispatcher rd = request.getRequestDispatcher("appointment-update.jsp");
		rd.forward(request, response);
	}



	private void deleteAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idappointment"));
		int rowEffected = this.appointmentDAO.deleteAppointment(id);
		
		if(rowEffected > 0) {
			//out.println("Successfully Deleted ID = "+id+" from result table");
			
			showAppointmentList(request, response);
		}
	}



	private void updateAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idappointment = Integer.parseInt(request.getParameter("idappointment"));
		String name = request.getParameter("pt_name");
		String doc_name = request.getParameter("doc_name");
		String pt_contact = request.getParameter("pt_contact");
		String date = request.getParameter("appointment_date");
		String message = request.getParameter("message");
		
		Appointment appointment = new Appointment(idappointment, name, doc_name, pt_contact, date, message);
		
		int rowEffected = this.appointmentDAO.updateAppointment(appointment);
		if(rowEffected > 0) {
			showAppointmentList(request, response);
		}
	}



	private void showAppointmentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList = this.appointmentDAO.getAppointmentList();
		request.setAttribute("appointmentList", appointmentList);
		
		List<Patient> patientList = this.patientDAO.getPatientList();
		request.setAttribute("patientList", patientList);
		
		RequestDispatcher rd = request.getRequestDispatcher("appointment-list.jsp");
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
