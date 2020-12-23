<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Education</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<style>
table,tr, td,th {
  border: 1px solid black;
  border-collapse: collapse;
 
}
</style>
<!-- menu -->
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="container">
		<div class="row mt-5">
			<div class="col-10">
				<h3>All courses</h3>
			</div>
			<div class="col-2">
				<c:url value="/course-add.jsp" var="add"></c:url>
				<a href="${add }" class="btn btn-primary">Add Course</a>
			</div>
		</div>
		<div class="row">
			<table class="table  border-dark">
				<tr>
					<th>CourseName</th>
					<th>Price</th>
					<th>Level</th>
					<th>Duration</th>
					<th>Start Date</th>
				</tr>
				<c:forEach items="${courselist }" var="course">
				<tr>
					<td>${course.name }</td>
					<td>${course.level }</td>
					<td>${course.price }</td>
					<td>${course.duration }</td>
					<td>${course.startDate }</td>
				</tr>
				</c:forEach>
				
			</table><hr />
		</div>
</div>
</body>
</html>