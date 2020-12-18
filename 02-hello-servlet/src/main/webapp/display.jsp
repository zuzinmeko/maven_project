<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login user information</title>
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
						<td>User Name</td>
						<td>
							<%out.println(request.getParameter("name")); %>
							<br />
							<%
							String name=(String)request.getAttribute("username");
							out.println(name); 
							%>
						</td>
					</tr>
					<tr>
						<td>Email</td>
						<td><%out.println(request.getParameter("email")); %></td>
					</tr>
					<tr>
						<td>Age</td>
						<td><%out.println(request.getParameter("age")); %></td>
					</tr>
					<tr>
						<td>Date of birth</td>
						<td>
							<%out.println(request.getParameter("dob")); %>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>