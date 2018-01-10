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
		<table border="1">
			<th>
				<td>Name</td>
				<td>Creator</td>
				<td>Version</td>
				<td>Action</td>
			</th>

			<c:forEach items="${languages}" var="language">
				<tr>
					<td>${ language.name }</td>
					<td>${ language.creator }</td>
					<td>${ language.version }</td>
					<td><a href="/languages/delete/${language.id}">Delete</a> <a href="/languages/${language.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>

		<br>

		<form:form method="post" action="/languages/new" modelAttribute="language">
			<form:label path="name">Name:
				<form:errors path="name"></form:errors>
				<form:input type="text" path="name"></form:input>
			</form:label>	

			<form:label path="creator">Creator:
				<form:errors path="creator"></form:errors>
				<form:input type="text" path="creator"></form:input>
			</form:label>

			<form:label path="version">Version:
				<form:errors path="version"></form:errors>
				<form:input type="text" path="version"></form:input>
			</form:label>

			<input type="submit" value="Create Language" />
		</form:form>
	</body>
</html>