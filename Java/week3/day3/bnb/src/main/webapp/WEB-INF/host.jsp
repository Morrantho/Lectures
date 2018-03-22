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
		<c:if test="${user != null}"><a href="/users/new">Logout</a></c:if>
		<a href="/listings">View Listings</a>

		<h1>Current Listings</h1>

		<table>
			<tr>
				<td>Address</td>
				<td>Size</td>
				<td>Cost</td>
				<td>Details</td>
			</tr>

			<c:forEach items="${user.listings}" var="listing">
				<tr>
					<td>${listing.address}</td>
					<td>${listing.size}</td>
					<td>${listing.cost}</td>
					<td><a href="/listings/${listing.id}">${listing.average}/5 - See More</a></td>
				</tr>
			</c:forEach>			
		</table>

		<form:errors path="listing.errors.*"></form:errors>

		<form:form method="POST" action="/listings" modelAttribute="listing">
			<form:label path="address">Address
				<form:input path="address"></form:input>
			</form:label>

			<form:label path="description">Description
				<form:input path="description"></form:input>
			</form:label>

			<form:label path="cost">Cost $
				<form:input type="number" path="cost"></form:input>
			</form:label>

			<form:label path="size">Size
				<form:select path="size">
					<form:option value="small">Small</form:option>
					<form:option value="medium">Medium</form:option>
					<form:option value="large">Large</form:option>
				</form:select>
			</form:label>

			<input type="submit" value="Create Listing">
		</form:form>			
	</body>
</html>