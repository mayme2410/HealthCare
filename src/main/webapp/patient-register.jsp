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
<c:import url="common/patient-register-header.jsp"></c:import>
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
          <h2 class="fw-bold mb-5">Sign up for Our Patient Member</h2>
          <form action="patient" method="post">
          
          <input type="hidden" name="mode" value="CREATE">
        
        	
            <!-- 2 column grid layout with text inputs for name and contact -->
            <div class="row">
              <div class="col-md-6 mb-4">
                <div class="form-outline">
                  <input type="text" id="name" name="name" placeholder="Enter Your Name" class="form-control" required autofocus>
                  <label for="name" class="form-label"></label>
                </div>
              </div>
              <div class="col-md-6 mb-4">
                <div class="form-outline">
                  <input type="text" id="contact" name="contact" placeholder="Enter Contact No" class="form-control" required autofocus>
                  <label for="contact" class="form-label"></label>
                </div>
              </div>
            </div>

            <!-- DOB input -->
            <div class="form-outline mb-4">
              <input type="date" id="dateofbirth" name="dateofbirth" placeholder="Enter Your Dateofbirth" class="form-control" required autofocus>
              <label for="dateofbirth" class="form-label"></label>
            </div>

            <!-- Address input -->
            <div class="form-outline mb-4">
              <input type="text" id="address" name="address" placeholder="Enter Your address" class="form-control" required autofocus>
              <label for="address" class="form-label"></label>
            </div>
            
            <!-- Username input -->
            <div class="form-outline mb-4">
              <input type="text" id="username" name="username" placeholder="Enter Your Username" class="form-control" required autofocus>
              <label for="username" class="form-label"></label>
            </div>
            
            <!-- Email & Password input -->
            <div class="row">
              <div class="col-md-6 mb-4">
                <div class="form-outline">
                  <input type="text" id="email" name="email" placeholder="Enter Your Email" class="form-control" required autofocus>
                  <label for="email" class="form-label"></label>
                </div>
              </div>
              <div class="col-md-6 mb-4">
                <div class="form-outline">
                  <input type="password" id="password" name="password" placeholder="Enter Your Password" class="form-control" required autofocus>
                  <label for="password" class="form-label"></label>
                </div>
              </div>
            </div>

            <!-- Checkbox -->
            

            <!-- Submit button -->
            
            <button type="submit" class="btn btn-primary btn-block mb-4">
              Sign up
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