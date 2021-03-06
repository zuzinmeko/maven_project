<%@page import="com.mmit.jpit.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee form</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="./common/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./common/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
		<div class="row offset-3 mt-3">
			<div class="col-6">
				<table class="table table-bordered border-primary table-dark">
					<tr>
						<th>Login Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Salary</th>
					</tr>
						<% 
						List<Employee> list=(ArrayList<Employee>)session.getAttribute("employeeList");
						for(Employee e:list){
						%>
						<tr>
							<td><%= e.getLoginName() %></td>
							<td><%= e.getEmail() %></td>
							<td><%= e.getPhone() %></td>
							<td><%= e.getSalary() %></td>
						</tr>
					<%}
					%>
				</table>
				<a href="index.jsp">Go Back</a>
			</div>
		</div>
	</div>
</body>
</html>