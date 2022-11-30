package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Doctor;
import com.hostmdy.model.DoctorDAO;
import com.hostmdy.model.Patient;
import com.hostmdy.model.PatientDAO;

/**
 * Servlet implementation class DoctorController
 */
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Resource(name = "jdbc/healthCareSystem")
	private DataSource datasource;
	private DoctorDAO doctorDAO;
	
	
	@Override
	public void init() throws ServletException {
		doctorDAO = new DoctorDAO(datasource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorController() {
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
			showDoctorList(request,response);
			break;
			
		case "LOAD": 
			loadDoctor(request, response);
			break;
		
		case "CREATE":
			createDoctor(request,response);
			break;
			
		case "UPDATE": 
			updateDoctor(request, response);
			break;
		
		case "DELETE": 
			deleteDoctor(request, response);
			break;
			
		default:
			showDoctorList(request, response);
			break;
		
		}
	}

	private void deleteDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("iddoctor"));
		int rowEffected = this.doctorDAO.deleteDoctor(id);
		
		if(rowEffected > 0) {
			//out.println("Successfully Deleted ID = "+id+" from result table");
			
			showDoctorList(request, response);
		}

	}

	private void updateDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int iddoctor = Integer.parseInt(request.getParameter("iddoctor"));
		String name = request.getParameter("doc_name");
		String work_exp = request.getParameter("work_exp");
		String degree = request.getParameter("degree");
		String fees = request.getParameter("fees");
		String specialization = request.getParameter("specialization");
		
		Doctor doctor = new Doctor(iddoctor, name, work_exp, degree, fees, specialization);
		
		int rowEffected = this.doctorDAO.updateDoctor(doctor);
		if(rowEffected > 0) {
			showDoctorList(request, response);
		}
	}

	
	private void createDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("doc_name");
		String work_exp = request.getParameter("work_exp");
		String degree = request.getParameter("degree");
		String fees = request.getParameter("fees");
		String specialization = request.getParameter("specialization");
		
		Doctor doctor = new Doctor(name, work_exp, degree, fees, specialization);
		
		int rowEffected = this.doctorDAO.createDoctor(doctor);
		if(rowEffected > 0) {
			registerDoctorList(request, response);
		}
	}

	private void registerDoctorList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean doctorRegister = true;
		request.setAttribute("doctorRegister", doctorRegister);
		RequestDispatcher rd = request.getRequestDispatcher("admin-main.jsp");
		rd.forward(request, response);
	}

	private void loadDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("iddoctor"));
		Doctor doctor = this.doctorDAO.getDoctorById(id);
		request.setAttribute("doctor", doctor);
		RequestDispatcher rd = request.getRequestDispatcher("doctor-update.jsp");
		rd.forward(request, response);
	}

	private void showDoctorList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Doctor> doctorList = this.doctorDAO.getDoctorList();
		
		request.setAttribute("doctorList", doctorList);
		RequestDispatcher rd = request.getRequestDispatcher("doctor-list.jsp");
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
