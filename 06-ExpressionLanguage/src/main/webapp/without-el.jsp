<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expression Language</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="./common/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./common/js/jquery.min.js"></script>
</head>
<body>
<%-- <h3>Expression Demo</h3>
<% out.println("1+2-"+(1+2)); %>
<hr />
<label >Result:</label>
<input type="text" value="${10+20}" /><hr /> --%>

<% 
	String name=request.getParameter("uname");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
	if(name==null)
		name="";
	if(email==null)
		email="";
	if(address==null)
		address="";
%>
<h3>Without Expression language</h3><hr>
	<div class="container">
		<div class="row offset mt-3">
			<div class="col-6">
			<form>
				<table class="m-3">
					<tr>
						<td>Name</td>
						<td>
						<input type="text" name="uname" value="<%= name %>"/>
						</td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email"  value="<%= email %>" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"  value="<%= address %>" /></td>
					</tr>
					<tr>
						<td></td>
						<td><button class="btn btn-info btn-sm">Display</button></td>
					</tr>
				</table>
				</form><hr />
				<h5>Result</h5>
				<% 
				if(!name.equals("") && !email.equals("") && !address.equals("")){
					%>
					Name:<%=name %>
					Email:<%=email %>
					Address:<%=address %>
				<%
				}
				%>
				
			</div>
		</div>
	</div>
	
</body>
</html>