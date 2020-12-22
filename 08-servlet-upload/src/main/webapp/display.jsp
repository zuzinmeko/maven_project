<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User show</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col">
			<h3>User profile</h3>
		</div>
		<div class="row">
		<table>
			<tr>
				<td>Name</td>
				<td>${userinfo.name}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${userinfo.email}</td>
			</tr>
			<tr>
				<td>Photo</td>
				<td>
				<img src="/08-servlet-upload/imgUploads/${userinfo.profile }" alt="img" width="150" height="150"/>
				</td>
			</tr>
		</table>
		</div>
	</div>
</div>
</body>
</html>