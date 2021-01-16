<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${item.id !=0 ? 'Edit' :'Add' }Item</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./common/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
	<jsp:include page="/common/menu1.jsp"></jsp:include>
</div>
<div class="container">
	<div class="row mt-3">
		<div class="col">
			<h3>${item.id !=0 ? 'Edit' :'Add' }Item</h3>
		</div>
	</div><br />
	<c:url value="/item-save" var="save"></c:url>
	<form action="${save }" class="form" method="post">
	<input type="hidden" value="${item.id}" name="itemid" />
		<div class="form-group col-6">
			<label class="form-label text">Product Name</label>
			<input value="${item.name }" type="text" class="form-control" name="name" placeholder="Enter product name ...." required="required" />
		</div>
		<div class="form-group col-6">
			<label class="form-label">Product Price</label>
			<input value="${item.price }" type="number" class="form-control" name="price" placeholder="Enter product price ...." required="required" />
		</div>
		<div class="form-group col-6">
			<label class="form-label">ExpireDate</label>
			<input value="${item.expiredate }" type="date" class="form-control" name="expire" />
		</div>
		<div class="form-group col-6">
			<label class="form-label">Choose Category</label>
			<select name="category" id="category" class="form-control">
				<c:forEach items="${categories}" var="c">
					<option value="${c.id }" selected="${item.category.id == c.id ? 'selected' :'' }">${c.name }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
		<button class="btn btn-warning" type="submit">submit</button>
		<button class="btn btn-danger" type="reset">clear</button>
		</div>
	
	</form>
</div>
</body>
</html>