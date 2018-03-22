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

		<c:if test="${user.isHost()}">
			<c:forEach items="${user.listings}" var="list">
				<c:if test="${ list.id == listing.id }">

					<form action="/listings/${listing.id}" method="POST">
						<label>Description:
							<input name="description" value="${listing.description}"></input>
						</label>

						<label>Size:
							<input name="size" value="${listing.size}"></input>
						</label>

						<label>Cost:
							<input name="cost" value="${listing.cost}"></input>
						</label>

						<input type="submit" value="Submit Changes!">
					</form>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${!user.isHost()}">		
			<p>${listing.address}</p>
			<p>${listing.description}</p>
			<p>Email: ${listing.user.email}</p>
			<p>Name: ${listing.user.firstName} ${listing.user.lastName}</p>
			<p>Size: ${listing.size}</p>
			<p>Cost $: ${listing.cost}</p>
		</c:if>


		<strong>Reviews: ( ${listing.average} / 5)</strong>
		
		<c:if test="${!user.host}"><a href="/listings/${listing.id}/review">Leave A Review</a></c:if>

		<div class="reviews">
			<c:forEach items="${listing.reviews}" var="review">
				<p>${review.user.firstName}:</p>
				<p>Rating: ${review.rating}/5</p>
				<p>${review.description}</p>
			</c:forEach>
		</div>
	</body>
</html>