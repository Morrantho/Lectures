<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Auctions</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" media="screen" href="main.css" />
	<script src="main.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>Product</td>
			<td>Seller</td>
			<td>Top Bid</td>
			<td>Time Remaining</td>
			<td>Actions</td>
		</tr>

		<c:forEach items="${bids}" var="bid" >
			<tr>
				<td>${bid.auction.name}</td>
				<td>${bid.auction.seller.name}</td>
				<td>${bid.auction.topBid}</td>
				<td>${bid.auction.remaining}</td>
				<td>
					<a href="/bids/${bid.id}/delete">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>