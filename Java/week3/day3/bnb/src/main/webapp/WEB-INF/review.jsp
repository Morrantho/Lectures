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
		<c:if test="${user != null}"><a href="/listings">Home</a></c:if>
		<c:if test="${user != null}"><a href="/users/new">Logout</a></c:if>

		<h1>Review Of: ${listing.address}</h1>

		<form:form action="/listings/${listing.id}/review" method="POST" modelAttribute="review">
			<form:label path="description">Description:
				<form:errors path="description"></form:errors>
				<form:textarea type="text" path="description"></form:textarea>
			</form:label>

			<form:label path="rating">Rating:
				<form:errors path="rating"></form:errors>
				<form:select path="rating">
					<c:forEach items="${numbers}" var="number">
						<form:option value="${number}">${number}</form:option>
					</c:forEach>
				</form:select>
			</form:label>

			<input type="submit" value="Submit Review">
		</form:form>
	</body>
</html>