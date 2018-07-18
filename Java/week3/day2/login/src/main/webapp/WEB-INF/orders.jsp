<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" rel="stylesheet"  integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"crossorigin="anonymous">
	<script src="main.js"></script>
	<link rel="stylesheet" type="text/css" media="screen" href="orders.css" />
	<title>Orders</title>
</head>
<body>
	<div class="form-group">
		<form action="/orders" method="POST" class="form-group">
			<select name="customer">
				<c:forEach items="${customers}" var="customer">
					<option value="${customer.id}">${customer.name}</option>
				</c:forEach>
			</select>

			<select name="product">
				<c:forEach items="${products}" var="product">
					<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</select>
			
			<input type="submit" value="Place Order" class="btn btn-success">
		</form>
		
		<h1 class="font-weight-bold">Orders</h1>

		<table class="table table-hover">
			<thead class="thead-dark">
				<tr class="info">
					<th>Name:</th>
					<th>Product:</th>
				</tr>
			</thead>
			
			<c:forEach items="${orders}" var="order" >
				<tr>
					<td>${order.customer.name}</td>

					<td>
						<c:forEach items="${order.products}" var="product" >
							${product.name}
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>