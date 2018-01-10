<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>

			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<title>Registration Page</title>
			</head>

			<body>
				<h1>Register!</h1>

				<p>
					<form:errors path="user.*" />
				</p>

				<form:form method="POST" action="/register" modelAttribute="user">
					<p>
						<form:label path="firstName">First Name:</form:label>
						<form:input path="firstName" />
					</p>
					<p>
						<form:label path="lastName">Last Name:</form:label>
						<form:input path="lastName" />
					</p>
					<p>
						<form:label path="email">Email:</form:label>
						<form:input path="email" />
					</p>
					<p>
						<form:label path="city">City:</form:label>
						<form:input path="city" />
					</p>
					<p>
						<form:label path="state">State:</form:label>
						<form:input path="state" />
					</p>
					<p>
						<form:label path="password">Password:</form:label>
						<form:password path="password" />
					</p>
					<p>
						<form:label path="passwordConfirmation">Password Confirmation:</form:label>
						<form:password path="passwordConfirmation" />
					</p>
					<input type="submit" value="Register!" />
				</form:form>
			</body>

			</html>