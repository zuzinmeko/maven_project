<%@page import="com.mmit.jpit.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create-Product page</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="./common/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./common/js/jquery.min.js"></script>
</head>
<body>
	<jsp:useBean id="product" class="com.mmit.jpit.Product" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="product"/>
	<jsp:forward page="/add-product"></jsp:forward>
	
</body>
</html>