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
			<thead><h2>Patient List</h2>
				<tr>
					<th>ID</th>
					
					<th>Name</th>
					<th>Contact</th>
					<th>Date Of Birth</th>
					<th>Address</th>
					<th>Username</th>
					<th>Email</th>
					
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="patient" items="${patientList}">
					<c:url var="updateLink" value="patient">
						<c:param name="mode" value="LOAD"></c:param>
						<c:param name="idpatient" value="${patient.idpatient }"></c:param>
					</c:url>
				
					<c:url var="deleteLink" value="patient">
						<c:param name="mode" value="DELETE"></c:param>
						<c:param name="idpatient" value="${patient.idpatient }"></c:param>
					</c:url>

					<tr>
						<td><c:out value="${patient.idpatient }"></c:out></td>
						<td><c:out value="${patient.name }"></c:out></td>
						
						<td><c:out value="${patient.contact }"></c:out></td>
						<td><c:out value="${patient.dateofbirth }"></c:out></td>
						<td><c:out value="${patient.address }"></c:out></td>
						
						<td><c:out value="${patient.username }"></c:out></td>
						<td><c:out value="${patient.email }"></c:out></td>
						
						

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