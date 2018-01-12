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
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<table>
			<thead>			
				<tr>
					<th>First Name:</th>
					<th>Last Name:</th>
					<th>Stack:</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${allStudents}" var="student" varStatus="id">
					<tr>
						<td><a href="/students/${id.index}">${student.firstName}</a></td>
						<td>${student.lastName}</td>
						<td>${student.stack}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<form action="/students/new" method="post">
			<label>First Name:
				<input type="text" name="firstName">
			</label>

			<label>Last Name:
				<input type="text" name="lastName">
			</label>

			<label>Stack:			
				<select name="stack">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
			</label>

			<input type="submit" value="Create Student">
		</form>

		<c:if test="${error != null}">
			<h1>${error}</h1>
		</c:if>
	</body>
</html>