<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Health Care System</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="css/main-styles.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/boostrap.min.css">
</head>
<body>
<c:import url="common/patient-home-header.jsp"></c:import>
<div class="m-4">
<!-- Section: Design Block -->
<section class="text-center">
  <!-- Background image -->
  <div class="p-5 bg-image" style="
        background-image: url('images/slider1.jpg');
        height: 300px;
        "></div>
  <!-- Background image -->

  <div class="card mx-4 mx-md-5 shadow-5-strong" style="
        margin-top: -100px;
        background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(30px);
        ">
    <div class="card-body py-5 px-md-5">

      <div class="row d-flex justify-content-center">
        <div class="col-lg-8">
          <h2 class="fw-bold mb-5">Book An Appointment</h2>
          <form action="patientdoctor" method="post">
          
          <input type="hidden" name="mode" value="CREATE">
        
        	
            <!-- 2 column grid layout with text inputs for name and contact -->
            <div class="row">
            	<div class="col-md-6 mb-4">
                <select class="form-select" aria-label="Default select example" name="pt_name">
   				 	
  					
  					<option value="${patient.name}">${patient.name}</option>
  					
  					
				</select>
              	</div>
              <div class="col-md-6 mb-4">
                <div class="form-outline">
                  <input type="text" id="pt_contact" name="pt_contact" placeholder="Enter Patient Contact Number" class="form-control" required autofocus>
                  <label for="pt_contact" class="form-label"></label>
                </div>
              </div>
              
              
            </div>
            
			<div class="form-outline mb-4">
                  
   				 <select class="form-select" aria-label="Default select example" name="doc_name">
   				 	
   				 	
  					
  					<option value="${doctor.doc_name}">${doctor.doc_name}</option>
  					
  					
				</select>
            </div>
            
            <div class="form-outline mb-4">
              <input type="date" id="appointment_date" name="appointment_date" placeholder="Enter Appointment Date" class="form-control" required autofocus>
              <label for="appointment_date" class="form-label"></label>
            </div>
            
            <div class="form-outline mb-4">
              <textarea id="message" name="message" placeholder="Why do you want to book appointment?" class="form-control" required autofocus></textarea>
            </div>
            
            <button type="submit" class="btn btn-primary btn-block mb-4">
              Book appointment
            </button>

            <!-- Register buttons -->
            
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->

</div>
</body>
</html>