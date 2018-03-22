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
		<c:if test="${user.isHost()}"><a href="/listings/host">Home</a></c:if>
		<c:if test="${!user.isHost()}"><a href="/listings">Home</a></c:if>

		<c:if test="${user != null}"><a href="/users/new">Logout</a></c:if>

		<h1>Find your Listing!</h1>

		<form method="GET" action="/listings/search">
			<input type="text" name="search">
			<input type="submit" value="Search">
		</form>

		<table>
			<tr>
				<td>Address</td>
				<td>Size</td>
				<td>Cost</td>
				<td>Details</td>
			</tr>

			<c:forEach items="${listings}" var="listing">
				<tr>
					<td>${listing.address}</td>
					<td>${listing.size}</td>
					<td>${listing.cost}</td>
					<td><a href="/listings/${listing.id}">${listing.average}/5 - See More</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>