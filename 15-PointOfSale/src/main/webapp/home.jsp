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
						<td>
						<c:url value="/add-to-cart" var="add">
							<c:param name="id" value="${i.id }"></c:param>
						</c:url>
						<a href="${add }">
						<i class="fa fa-cart-plus fa-2x "></i>
						</a></td>
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
									<th>Price</th>
									<th>Quantity</th>
									<th>Total Price</th>
								</tr>
						</thead>
						<tbody>
							<!-- display cartlist --> 
							<c:forEach items="${cart.detaillist}" var="sd">
								<tr>
									<td>${sd.item.name}</td>
									<td>${sd.item.price}</td>
									<td>${sd.subQty }</td>
									<td>${sd.item.price * sd.subQty}</td>
								</tr>
								
							</c:forEach>
							<tr class="${empty cart ? 'd-none' : '' }">
									<td colspan="3" align="right">SubTotal:</td>
									<td>${cart.subTotal}</td>
							</tr>
							<tr class="${empty cart ? 'd-none' : '' }">
								<td colspan="3" align="right">Tax:</td>
								<td>${cart.tax}</td>
							</tr>
							<tr class="${empty cart ? 'd-none' : '' }">
								<td colspan="3" align="right">Total:</td>
								<td>${cart.total}</td>
							</tr>
						</tbody>	
				</table>
				<c:url value="/cart-action" var="action"></c:url>
				<form action="${action}" class="form" method="post">
					<div class="form-row">
						<div class="col">
							<input type="submit" class="form-control btn btn-primary ${empty cart ? 'd-none' : ''}" value="Paid" name="btnAction" />
						</div>
						<div class="col">
							<input type="submit" class="form-control btn btn-danger ${empty cart ? 'd-none' : ''}" value="Clear" name="btnAction" />
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