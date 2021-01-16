<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item list Home Page</title>
<link href="./common/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<c:url value="home" var="home"></c:url>
	<c:redirect url="${home }"></c:redirect>
	<div class="container">
	<jsp:include page="/common/menu1.jsp"></jsp:include>
</div>
</body>
</html>