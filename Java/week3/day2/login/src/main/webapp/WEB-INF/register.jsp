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
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="/js/main.js"></script>
		<link rel="stylesheet" href="/css/style.css">
		<title>Index</title>
	</head>

	<body>
		<c:if test="${registerError != null}">
			<p >${registerError}</p>			
		</c:if>
		
		<c:if test="${errors != null}">
			<c:forEach items="${errors}" var="error">
				<p class="red">${error.defaultMessage}</p>
			</c:forEach>		
		</c:if>		
	
		<form:form action="/register" method="POST" modelAttribute="user">
			<p>First:<form:input path="first"/></p>
			<form:errors path="first"></form:errors>

			<p>Last:<form:input path="last"/></p>
			<form:errors path="last"></form:errors>

			<p>Email:<form:input path="email"/></p>
			<form:errors path="email"></form:errors>

			<p>Username:<form:input path="username"/></p>
			<form:errors path="username"></form:errors>

			<p>Password:<form:input path="password"/></p>
			<form:errors path="password"></form:errors>

			<input type="submit" value="Register" />
		</form:form>
		
		<form action="/login" method="POST">
			<p>Email:<input type="text" name="email" /></p>
			<p>Password:<input type="password" name="password" /></p>
			<input type="submit" value="Login" />
		</form>
	</body>
</html>