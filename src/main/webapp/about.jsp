<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Doctor List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="css/main-styles.css">
<link rel="stylesheet" href="css/style.css">

<script src="https://kit.fontawesome.com/f98d709abc.js" crossorigin="anonymous"></script>


</head>
<body>
	<c:import url="common/header.jsp"></c:import>
	<div class="p-5 bg-image" style="background-image: url('images/about.jpg'); height: 500px;">
		<div class="row">
			<div class="col-lg-12">
				<h4 style="color: #FFFFFF;letter-spacing: 2px;text-align: center;padding-top: 150px;">About HealthCare</h4>

			</div>
		</div>
	</div>
	
	
	<section class="special-program section-padding">
		<div class="flex-container">
			<div class="flex-child">
				<h4>A great medical team to help your needs</h4>
				<br>
				<p>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit.
				 Curabitur ante leo, finibus quis est ut, tempor tincidunt ipsum.
				 Nam consequat semper sollicitudin. Aliquam nec dapibus massa.
				 Pellen tesque in luctus ex. 
				</p>
				</div>
				<div class="flex-child">
				<img alt="section" src="images/text_section.jpg" width= 500px height= 300px>
				</div>
				
				
				
				

			</div>
		
	</section>
	<section class="specialist-area section-padding">
		<div class="flex-container">
				<div class="flex-child">
				<img alt="program" src="https://myancare.org/wp-content/uploads/2021/07/Yin-Thway-Service.png">
				</div>
				
				<div class="flex-child">
				<h4>YinTway Call Center</h4>
				<br>
				<p>
				YinThway Call Center is a hospital-based 24/7 medical call center service specialized in Pediatric Healthcare. Pediatric specialists from Yin Thway Call Center connect parents and their children to care with their regular pediatrician or another online doctor.
				</p>
				
				</div>
				
				

			</div>
		
	</section>
	<section>
		<div class="p-5 bg-image"style="background-image: url('images/cta.jpg'); height: 450px;">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="cta-h2">Need a personal health plan?</h2>
					<p class="cta-p">Loreum Duis massa massa, mollis vel ullamcorper quis, finibus et urna. 
					Aliquam ac eleifend metus. Ut sollicitudin risus ex</p>
				</div>
			</div>
		</div>
	</section>
	
	<c:import url="common/footer.html"></c:import>

	<script src="js/common.js"></script>
</body>
</html>