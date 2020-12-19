<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Student List</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="/common/menu.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<div class="col-10 mt-5">
			<h3>All students</h3> <hr />
		</div>
		<div class="col-2 mt-5">
				<c:url value="/student-add.jsp" var="studentadd"></c:url>
				<a href="${studentadd }" class="btn btn-primary">Add Student</a>
		</div>
	</div>
	<div class="row">
		<table class="table table-info border-dark">
			<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Year</th>
					<th>Age</th>
					<th>Address</th>
					<th>Date of birth</th>
			</tr>
			<c:forEach items="${studentlist }" var="student">
				<tr>
					<td>${student.name }</td>
					<td>${student.email }</td>
					<td>${student.year }</td>
					<td>${student.age }</td>
					<td>${student.address }</td>
					<td>${student.dateOfBirth }</td>
				</tr>
				</c:forEach>
		</table>
	</div>
</div>


</body>
</html>