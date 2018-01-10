<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<body>
		<h1>Welcome, ${currentUser.firstName}</h1>
		
		<h3>Here are some of the events in your state.</h3>

		<table border="1">
			<tr>
				<th>Name:</th>
				<th>Date:</th>
				<th>Location:</th>
				<th>Host:</th>
				<th>Aciton / Status</th>
			</tr>

			<tr>

			</tr>
		</table>

		<br><br>
			
		<h3>Here are some of the events in other states.</h3>
			
		<table border="1">
			<tr>
				<th>Name:</th>
				<th>Date:</th>
				<th>Location:</th>
				<th>State</th>
				<th>Host:</th>
				<th>Action / Status</th>
			</tr>

			<tr>
				
			</tr>
		</table>

		<form:form action="/events/new" method="POST" modelAttribute="event">
			<form:label path="name">
				<form:errors path="name"></form:errors>
				<form:input path="name"></form:input>
			</form:label>

			<form:label path="date">
				<form:errors path="date"></form:errors>
				<form:input type="date" path="date"></form:input>
			</form:label>

			<form:label path="city">
				<form:errors path="city"></form:errors>
				<form:input path="city"></form:input>
			</form:label>

			<form:label path="state">
				<form:errors path="state"></form:errors>
				<form:input path="state"></form:input>
			</form:label>

			<input type="submit" />
		</form:form>
	</body>
</html>