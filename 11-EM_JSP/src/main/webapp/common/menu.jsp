<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/common/css/bootstrap.min.css" var="bsCSS"></c:url>
<c:url value="/common/js/bootstrap.min.js" var="bsJS"></c:url>
<c:url value="/common/js/jquery.min.js" var="jsJS"></c:url>
 
 <link href="${bsCSS }" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${bsJS }"></script>
<script type="text/javascript" src="${jsJS }"></script>

<nav class="navbar navbar-expand-lg navbar-dark bg-info">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">Education</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNav">
		      <ul class="navbar-nav">
		        <li class="nav-item">
		        	<c:url value="/courses" var="course"></c:url>
		          <a class="nav-link ${empty title ? 'active' :'' }" aria-current="page" href="${course }">Course List</a>
		        </li>
		        <li class="nav-item">
		        	<c:url value="/add-course" var="courseAdd"></c:url>
		          <a class="nav-link  ${(not empty title and title=='addcourse') ? 'active' :''}" href="${courseAdd }">Add course</a>
		        </li>
		        <li class="nav-item">
		        <c:url value="/students" var="student"></c:url>
		          <a class="nav-link ${(not empty title and title=='students') ? 'active' :''}" href="${student }">Student list</a>
		        </li>
		        <li class="nav-item">
		        <c:url value="/add-student" var="studentAdd"></c:url>
		          <a class="nav-link ${(not empty title and title=='addstudent') ? 'active' :''}" href="${studentAdd }">Add student</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>