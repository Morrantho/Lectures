<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Page Title</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" media="screen" href="main.css" />
	<script src="main.js"></script>
</head>
<body>
	<h1>Seller</h1>
	<form:form action="/sellers" method="POST" modelAttribute="seller">
		<p><form:label path="firstName" >First Name:
			<form:errors path="firstName"></form:errors>
			<form:input path="firstName"></form:input>
		</form:label></p>			
		<p><form:label path="lastName" >Last Name:
			<form:errors path="lastName"></form:errors>
			<form:input path="lastName"></form:input>
		</form:label></p>
		<p><form:label path="email" >Email:
			<form:errors path="email"></form:errors>
			<form:input path="email"></form:input>
		</form:label></p>
		<p><form:label path="password" >Password:
			<form:errors path="password"></form:errors>
			<form:input path="password"></form:input>
		</form:label></p>

		<form:input path="wallet" type="hidden" value="1000.0"></form:input>

		<input type="submit" value="Register As Seller" />
	</form:form>

	<form action="/sellers/login" method="POST">
		<p>Email:<input name="email" /></p>
		<p>Password:<input name="password" /></p>
		<input type="submit" value="Login As Seller" />
	</form>
</body>
</html>