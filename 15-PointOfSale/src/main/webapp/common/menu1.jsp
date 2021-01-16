<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/common/css/bootstrap.min.css" var="bsCSS"></c:url>
<c:url value="/common/js/bootstrap.min.js" var="bsJS"></c:url>
<c:url value="/common/js/jquery.min.js" var="jsJS"></c:url>
<c:url value="/common/js/font-awesome.min.js" var="faCSS"></c:url>

<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
 <link href="${bsCSS }" rel="stylesheet" type="text/css">
 <link href="${faCSS }" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${bsJS }"></script>
<script type="text/javascript" src="${jsJS }"></script>

<nav class="navbar navbar-expand-lg navbar-success bg-warning">
		  <div class="container">
		  <c:url value="/home" var="home"></c:url>
		    <a class="navbar-brand active" href="${home}">
		    <i class="fa fa-home"></i>
		    POS
		    </a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNav">
		      <ul class="navbar-nav">
		        <li class="nav-item">
		        <c:url value="/items" var="items"></c:url>
		        <a class="nav-link" aria-current="page" href="${items }">
		        <i class="fa fa-list-ul"></i>
		            Items</a>
		        </li>
		        <li class="nav-item">
		        	<c:url value="/item-add" var="itemAdd"></c:url>
		          <a class="nav-link " href="${itemAdd }">
		          <i class="fa fa-plus-square"></i>
		          Add item</a>
		        </li>
		        <li class="nav-item">
		        <c:url value="/sale" var="sale"></c:url>
		          <a class="nav-link" href="${sale }"><i class="fa fa-support"></i>Sale</a>
		        </li>
		        
		      </ul>
		    </div>
		  </div>
		</nav>