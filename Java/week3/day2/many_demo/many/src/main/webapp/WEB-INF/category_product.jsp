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

		<form action="/categories/add" method="post">
			<select name="category_id">			
				<c:forEach items="${categories}" var="cat">
					<option value="${cat.id}">${cat.name}</option>
				</c:forEach>
			</select>
			
			<select name="product_id">
				<c:forEach items="${products}" var="pro">
					<option value="${pro.id}">${pro.name}</option>
				</c:forEach>				
			</select>

			<input type="submit" />
		</form>

	</body>
</html>