<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items</title>
<link href="./common/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
	<jsp:include page="/common/menu1.jsp"></jsp:include>
</div>
<div class="container">
	<div class="row mt-3">
		<div class="col">
			<h3>All Items</h3>
		</div>
	</div><br />

	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Expire date</th>
				<th>Category</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${itemlist }" var="i">
				<tr>
					<td>${i.id }</td>
					<td>${i.name }</td>
					<td>${i.price }</td>
					<td>${i.expiredate }</td>
					<td>${i.category.name }</td>
					<td>
					<c:url value="/item-edit" var="edit">
						<c:param name="id" value="${i.id }"></c:param>
					</c:url>
						<a href="${edit }">
						<i class="fa fa-edit"></i>
							Edit
						</a>
					
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>