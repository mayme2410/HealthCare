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

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
<link rel="stylesheet" href="css/main-styles.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/boostrap.min.css">

<title>Patient List</title>

</head>
<body>

<c:import url="common/patient-home-header.jsp"></c:import>
<div class="m-4">
<table id="result" class="table table-striped">
			<thead><h2>Doctor List</h2>
				<tr>
					<th>ID</th>
					
					<th>Name</th>
					<th>Work Experience</th>
					<th>Degree</th>
					<th>Fees</th>
					<th>Specialization</th>
					
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="doctor" items="${doctorList}">
					<c:url var="appointmentLink" value="patientdoctor">
						<c:param name="mode" value="APPOINT"></c:param>
						<c:param name="iddoctor" value="${doctor.iddoctor }"></c:param>
						
					</c:url>
					
					

					<tr>
						<td><c:out value="${doctor.iddoctor }"></c:out></td>
						<td><c:out value="${doctor.doc_name }"></c:out></td>
						
						<td><c:out value="${doctor.work_exp }"></c:out></td>
						<td><c:out value="${doctor.degree }"></c:out></td>
						<td><c:out value="${doctor.fees }"></c:out></td>
						
						<td><c:out value="${doctor.specialization }"></c:out></td>
						

						<td><a href="${appointmentLink }" class="btn btn-primary">Appointment</a>
						
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>

<script src="js/common.js"></script>
</body>
</html>