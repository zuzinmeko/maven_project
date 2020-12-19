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
<h3 class="mt-3">With Expression language</h3><hr>
	<div class="container">
		<div class="row offset mt-3">
			<div class="col-6">
			<form>
				<table class="m-3">
					<tr>
						<td>Name</td>
						<td>
						<input type="text" name="uname" value="${param.uname}"/>
						</td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email"  value="${param.email }" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"  value="${param.address }" /></td>
					</tr>
					<tr>
						<td></td>
						<td><button class="btn btn-info btn-sm">Display</button></td>
					</tr>
				</table>
				</form><hr />
				<h5 style="color: red;">Result</h5> <hr />
				<table>
					<tr>
						<td>UserName :${param.uname } </td>
					</tr>
					<tr>
						<td>Email :${param.email }</td>
					</tr>
					<tr>
						<td>Address :${param.address }</td>
					</tr>
				</table> <hr />
			</div>
		</div>
	</div>
	
</body>
</html>