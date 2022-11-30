<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="sticky-top">
<div>
	<!-- Top Bar -->
		<div class="top_bar">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="top_bar_content d-flex flex-row align-items-center justify-content-start">
							<div class="top_bar_item">
								<a href="#">FAQ</a>
							</div>
							<div class="top_bar_item">
								<a href="patient-signin.jsp">Request an Appointment</a>
							</div>
							<div
								class="emergencies  d-flex flex-row align-items-center justify-content-start ml-auto">For
								Emergencies: +563 47558 623</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<nav class="navbar sticky-top navbar-expand-lg navbar-light bg-white">
        <div class="container-fluid">
            <a href="#" class="navbar-brand">
                <img src="images/healthcare_logo.png" height="100" alt="CoolBrand">
            </a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav">
                
                    <a href="admin-main.jsp" class="nav-item nav-link active">Home</a>
                    <a href="admin-aboutus.jsp" class="nav-item nav-link active">About Us</a>
                    
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle active" data-bs-toggle="dropdown">Add New</a>
                        <div class="dropdown-menu">
                            <a href="doctor-register.jsp" class="dropdown-item">Doctor</a>
                            
                            
                            
                            <a href="appointment" class="dropdown-item">Appointment</a>
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle active" data-bs-toggle="dropdown">Reports</a>
                        <div class="dropdown-menu">
                            <a href="doctorlist" class="dropdown-item">Doctor</a>
                            
                            <a href="patient" class="dropdown-item">Patient</a>
                            
                            <a href="appointmentshow" class="dropdown-item">Appointment</a>
                        </div>
                    </div>
                    <a href="main.jsp" class="nav-item nav-link active" tabindex="-1">Contact Us</a>
                    <a href="main.jsp" class="nav-item nav-link active" tabindex="-1">Logout</a>
                    
                    
                </div>
                
            </div>
        </div>
    </nav>
</div>
</header>

