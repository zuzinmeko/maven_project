<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="./common/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./common/js/jquery.min.js"></script>
</head>
<body>
		<div class="container">
			<div class="row mt-3">
				<div class="col-6 offset-3">
					<div class="card">
						<div class="card-header">
						<h3>Register Form</h3>
						</div>
						
					</div>
					<div class="card-body">
					<form action="register" class="form" method="post">
					<div class="form-group">
					<label for="">Login User Name</label>
					<input type="text" name="name" class="form-control" />
					</div>
					<div class="form-group">
					<label for="">Login Email</label>
					<input type="email" name="email" class="form-control" />
					</div>
					<div class="form-group">
					<label for="">Login Password</label>
					<input type="password" name="pass" class="form-control" />
					</div>
					<div class="form-group">
					<label for="">Date of Birth</label>
					<input type="date" name="dob" class="form-control" />
					</div>
					<div class="form-group">
					<label for="">Age</label>
					<input type="number" name="age" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
					<button type="submit" class="btn btn-danger">Cancel</button>
				</form>
				</div>
				</div>
			</div>
		</div>
</body>
</html>