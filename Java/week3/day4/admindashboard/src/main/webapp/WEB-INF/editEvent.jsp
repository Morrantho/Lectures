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
	<h1>${event.name}</h1>

	<h3>${event.host}</h3>
	<h3>${event.date}</h3>
	<h3>${event.city}, ${event.state}</h3>
	<h3>Users attending: ${event.users.size()}</h3>

	<table border="1">
		<tr>
			<td>Name</td>
			<td>City</td>
		</tr>

		<c:forEach items="${event.users}" var="user">
			<tr>
				<td>${user.name}</td>
				<td>${user.city}</td>
			</tr>
		</c:forEach>
	</table>

	<!-- Right Half -->

	<div style="width:50%; height:50%; overflow:auto;" >
		<c:forEach items="${event.comments}" var="comment">
			<h3>${comment.user} says ${comment.text}</h3>
		</c:forEach>
	</div>

	<form:form action="/events/${event.id}/comments/new" method="post" modelAttribute="comment">
		<form:label path="text">
			<form:errors path="text"></form:errors>
			<form:input path="text" type="text"></form:input>
		</form:label>
		<form:label path="user">
			<form:errors path="user"></form:errors>
			<form:input path="user" type="text"></form:input>
		</form:label>

		<input type="submit" value="Create Comment" />
	</form:form>
</body>

</html>