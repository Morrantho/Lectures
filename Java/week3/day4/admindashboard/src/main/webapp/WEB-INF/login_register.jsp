<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Login | Register</title>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	
	<body>
		<div class="container">
			<h1>Login</h1>

		    <c:if test="${errorMessage != null}">
				<div class="alert alert-danger alert-dismissable">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<c:out value="${errorMessage}"></c:out>
				</div>
		    </c:if>
		    <c:if test="${logoutMessage != null}">
				<div class="alert alert-danger alert-dismissable">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<c:out value="${logoutMessage}"></c:out>
				</div>
		    </c:if>

			<form class="form-horizontal" action="/login" method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="username">Email:</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="username" placeholder="Enter Email" name="username">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="password">Password:</label>
					<div class="col-sm-10">          
						<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
					</div>
				</div>
				
				<div class="form-group">        
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Login</button>
					</div>
				</div>
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></input>
			</form>
		
			<h1>Register</h1>
			<!-- I feel like we should be doing errors this way -->
			<spring:hasBindErrors name="user">
				<c:forEach items="${errors.allErrors}" var="error">
					<div class="alert alert-danger alert-dismissable">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
						<spring:message message="${error}"></spring:message>
					</div>					
				</c:forEach>
			</spring:hasBindErrors>

			<form:form name="register" class="form-horizontal" action="/register" method="post" modelAttribute="user">
				<div class="form-group">
					<form:label class="control-label col-sm-2" path="email">Email:</form:label>
					<div class="col-sm-10">
						<form:input type="email" class="form-control" id="email" placeholder="Enter email" path="email"></form:input>
					</div>
				</div>
			
				<div class="form-group">
					<form:label class="control-label col-sm-2" path="firstName">First Name:</form:label>
					<div class="col-sm-10">
						<form:input type="text" class="form-control" id="firstName" placeholder="Enter First Name" path="firstName"></form:input>
					</div>
				</div>

				<div class="form-group">
					<form:label class="control-label col-sm-2" path="lastName">Last Name:</form:label>
					<div class="col-sm-10">
						<form:input type="text" class="form-control" id="lastName" placeholder="Enter Last Name" path="lastName"></form:input>
					</div>
				</div>	

				<div class="form-group">
					<form:label class="control-label col-sm-2" path="state">State:</form:label>
					<div class="col-sm-10">
						<form:input type="text" class="form-control" id="state" placeholder="Enter State" path="state"></form:input>
					</div>
				</div>


				<div class="form-group">
					<form:label class="control-label col-sm-2" path="password">Password:</form:label>
					<div class="col-sm-10">
						<form:input type="password" class="form-control" id="password" placeholder="Enter Password" path="password"></form:input>
					</div>
				</div>	
	
				<div class="form-group">
					<form:label class="control-label col-sm-2" path="confirm">Confirm Password:</form:label>
					<div class="col-sm-10">
						<form:input type="password" class="form-control" id="confirm" placeholder="Confirm Password" path="confirm"></form:input>
					</div>
				</div>	
				
				<div class="form-group">        
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Register</button>
					</div>
				</div>
			</form:form>		
		</div>
	</body>
</html>