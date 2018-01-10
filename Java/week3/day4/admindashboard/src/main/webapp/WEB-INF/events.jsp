<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE HTML>
<html>

<head>
	<title>Events</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<h1>Welcome, </h1>

	<h3>Here are some of the events in your state:</h3>

	<table border="1">
		<tr>
			<td>Name</td>
			<td>Date</td>
			<td>City</td>
			<td>Host</td>
			<td>Action / Status</td>
		</tr>

		<c:forEach items="${localEvents}" var="e">
			<tr>
				<td>${e.name}</td>
				<td>${e.date}</td>
				<td>${e.city}</td>
				<td>${e.host}</td>
				<td>Join Edit Delete</td>
			</tr>
		</c:forEach>
	</table>

	<h3>Here are some events in other states.</h3>

	<table border="1">
		<tr>
			<td>Name</td>
			<td>Date</td>
			<td>City</td>
			<td>State</td>
			<td>Host</td>
			<td>Action / Status</td>
		</tr>

		<c:forEach items="${otherEvents}" var="e">
			<tr>
				<td>${e.name}</td>
				<td>${e.date}</td>
				<td>${e.city}</td>
				<td>${e.state}</td>
				<td>${e.host}</td>
				<td>Join Edit Delete</td>
			</tr>
		</c:forEach>
	</table>

	<form:form action="/events/new" method="post" modelAttribute="event">
		<form:label path="name">Name:
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</form:label>
		<form:label path="date">date:
			<form:errors path="date"></form:errors>
			<form:input type="date" path="date"></form:input>
		</form:label>
		<form:label path="city">city:
			<form:errors path="city"></form:errors>
			<form:input path="city"></form:input>
		</form:label>
		<form:label path="state">state:
			<form:errors path="state"></form:errors>
			<form:input path="state"></form:input>
		</form:label>
		<form:label path="host">host:
			<form:errors path="host"></form:errors>
			<form:input path="host"></form:input>
		</form:label>

		<input type="submit" value="Create Event" />
	</form:form>
</body>

</html>