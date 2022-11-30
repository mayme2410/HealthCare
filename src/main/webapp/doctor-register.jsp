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
<c:import url="common/admin-header.jsp"></c:import>
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
          <h2 class="fw-bold mb-5">Sign up for Doctor</h2>
          <form action="doctorlist" method="post">
          
          <input type="hidden" name="mode" value="CREATE">
        
        	
            <!-- 2 column grid layout with text inputs for name and contact -->
            <div class="row">
              <div class="col-md-6 mb-4">
                <div class="form-outline">
                  <input type="text" id="doc_name" name="doc_name" placeholder="Enter Doctor Name" class="form-control" required autofocus>
                  <label for="doc_name" class="form-label"></label>
                </div>
              </div>
              <div class="col-md-6 mb-4">
                <div class="form-outline">
                  <input type="text" id="work_exp" name="work_exp" placeholder="Enter Work Experience" class="form-control" required autofocus>
                  <label for="work-exp" class="form-label"></label>
                </div>
              </div>
            </div>

            <!-- Degree input -->
            <div class="form-outline mb-4">
              <input type="text" id="degree" name="degree" placeholder="Enter Doctor Degree" class="form-control" required autofocus>
              <label for="degree" class="form-label"></label>
            </div>

            <!-- Fees input -->
            <div class="form-outline mb-4">
              <input type="text" id="fees" name="fees" placeholder="Enter Doctor's Consultation Fees" class="form-control" required autofocus>
              <label for="fees" class="form-label"></label>
            </div>
            
            <!-- Specialization input -->
            <div class="form-outline mb-4">
              <input type="text" id="specialization" name="specialization" placeholder="Enter Doctor's Specialization" class="form-control" required autofocus>
              <label for="specialization" class="form-label"></label>
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