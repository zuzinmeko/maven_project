<%@page import="com.mmit.jpit.scope.Counter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="./common/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./common/js/jquery.min.js"></script>
</head>
<body>
<h1>Scope Object</h1>
<table>
	<tr>
		<td>Application Scope</td>
		<td>
		<% 
		Counter appCounter=(Counter)application.getAttribute("counter");
		out.println((appCounter==null)? 0 : appCounter.getCount());
		%>
		</td>
	</tr>
	<tr>
		<td>Session Scope</td>
		<td>
		<% Counter sessionCounter=(Counter)session.getAttribute("counter");
		out.println((sessionCounter==null)? 0 : sessionCounter.getCount()); %>
		</td>
	</tr>
	<tr>
		<td>Request Scope</td>
		<td>
		<% Counter requestCounter=(Counter)request.getAttribute("counter");
		out.println((requestCounter==null)? 0 : requestCounter.getCount()); %>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><a href="count">Count Up</a></td>
	</tr>
</table>
<hr />
<h3>Directive and action include</h3>
<ul>
	<li>
	<a href="output1.jsp">Include Directive</a>
	</li>
	<li>
	<a href="output2.jsp">Include Action Tag</a>
	</li>
	<li>
	<a href="output3.jsp">Forward</a>
	</li>
</ul>


</body>
</html>