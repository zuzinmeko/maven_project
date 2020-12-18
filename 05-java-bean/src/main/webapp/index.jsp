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
<h3>Add New Product</h3>
<form action="create-product.jsp">
	<table>
		<tr>
			<td>Name</td>
			<td>
			<input type="text" name="name" />
			</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>
			<input type="number" name="price" />
			</td>
		</tr>
		<tr>
			<td>CategoryName</td>
			<td>
			<input type="text" name="categoryName" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
			<button type="submit">Add toProduct</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>