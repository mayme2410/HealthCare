<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="common/patient-list-header.html"></c:import>
<title>Patient List</title>

</head>
<body>


<div class="m-4">

<table id="result" class="table table-striped">

		<thead><h2>Appointment List</h2>
				<tr>
					<th>ID</th>
					
					<th>Patient Name</th>
					<th>Patient Contact</th>
					<th>Doctor Name</th>
					<th>Appointment Date</th>
					<th>Message</th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="appointment" items="${appointmentList}">
					<c:url var="updateLink" value="appointmentshow">
						<c:param name="mode" value="LOAD"></c:param>
						<c:param name="idappointment" value="${appointment.idappointment }"></c:param>
					</c:url>
				
					<c:url var="deleteLink" value="appointmentshow">
						<c:param name="mode" value="DELETE"></c:param>
						<c:param name="idappointment" value="${appointment.idappointment }"></c:param>
					</c:url>
					

					<tr>
						<td><c:out value="${appointment.idappointment }"></c:out></td>
						<td><c:out value="${appointment.name }"></c:out></td>
						<td><c:out value="${appointment.pt_contact }"></c:out></td>
						
						<td><c:out value="${appointment.doc_name }"></c:out></td>
						<td><c:out value="${appointment.date }"></c:out></td>
						
						<td><c:out value="${appointment.message }"></c:out></td>
						
						<td><a href="${updateLink }" class="btn btn-primary">Edit</a>
						<a href="${deleteLink }" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this result?');">Delete</a>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
</div>

<script src="js/common.js"></script>
</body>
</html>