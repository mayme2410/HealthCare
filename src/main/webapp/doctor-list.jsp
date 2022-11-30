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
					<c:url var="updateLink" value="doctorlist">
						<c:param name="mode" value="LOAD"></c:param>
						<c:param name="iddoctor" value="${doctor.iddoctor }"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="doctorlist">
						<c:param name="mode" value="DELETE"></c:param>
						<c:param name="iddoctor" value="${doctor.iddoctor }"></c:param>
					</c:url>

					<tr>
						<td><c:out value="${doctor.iddoctor }"></c:out></td>
						<td><c:out value="${doctor.doc_name }"></c:out></td>
						
						<td><c:out value="${doctor.work_exp }"></c:out></td>
						<td><c:out value="${doctor.degree }"></c:out></td>
						<td><c:out value="${doctor.fees }"></c:out></td>
						
						<td><c:out value="${doctor.specialization }"></c:out></td>
						
						
						

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