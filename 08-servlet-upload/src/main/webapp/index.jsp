<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User information</title>
</head>
<body>
<h3>Servlet file upload</h3>
<c:url value="/register" var="action"></c:url>
	<form action="${action }" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Name</td>
			<td>
			<input type="text" name="name" />
			</td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" /></td>
		</tr>
		<tr>
			<td>Photo</td>
			<td><input type="file" name="photo" /></td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit" class="btn btn-primary">Save</button></td>
		</tr>
	</table>
	
	</form>
</body>
</html>