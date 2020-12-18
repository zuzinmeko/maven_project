<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forward</title>
</head>
<body>
<jsp:forward page="output.jsp">
	<jsp:param value="susu" name="username"/>
	<jsp:param value="su@gmail.com" name="email"/>
</jsp:forward>
</body>
</html>