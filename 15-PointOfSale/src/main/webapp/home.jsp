<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="./common/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
	<jsp:include page="/common/menu1.jsp"></jsp:include>
</div>
<div class="container">
	<div class="row mt-3">
		<div class="col-6">
			<h4>Display Item list</h4><br />
			<table class="table">
				<thead>
					<tr>
						<th>Product name</th>
						<th>Price</th>
						<th>Expired date</th>
						<th>Category</th>
						<th>Move to <i class="fa fa-cart-plus"></i></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${itemlist }" var="i">
					<tr>
						<td>${i.name }</td>
						<td>${i.price }</td>
						<td>${i.expiredate }</td>
						<td>${i.category.name}</td>
						<td><i class="fa fa-cart-plus fa-2x "></i></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-6">
			<div class="card mt-3">
				<div class="card-body">
					<h4>Sale Details</h4><br />
					<table class="table">
						<thead>
							<tr>
									<th>Product</th>
									<th>Qty</th>
									<th>Price</th>
									<th>Total Price</th>
								</tr>
						</thead>
						<tbody>
							<!-- display cartlist --> 
						</tbody>	
				</table>
				
				<form action="" class="form" method="post">
					<div class="form-row">
						<div class="col">
							<button class="form-control btn btn-primary" type="submit">Paid</button>
						</div>
						<div class="col">
							<button class="form-control btn btn-danger" type="submit">Cancel</button>
						</div>
					</div>
				</form>
			</div>
				
			
			</div>
			</div>
		</div>
	</div><br />
</div>
</body>
</html>