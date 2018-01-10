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
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<body>
		<h1>Categories And Products</h1>
		
		<c:forEach items="${categories_products}" var="stuff">
			<p>Category Name: ${ stuff.category.name }</p>
			<p>Product Name: ${ stuff.product.name }</p>
			<br>
		</c:forEach>

		<br>

		<form action="/add" method="post">
			<select name="category" >
				<c:forEach items="${categories}" var="category">
					<option value="${ category.id }" > ${category.name} </option>
				</c:forEach>
			</select>

			<select name="product">
				<c:forEach items="${products}" var="product">
					<option value="${ product.id }" > ${product.name} </option>
				</c:forEach>
			</select>
			
			<input type="submit" value="Add" />
		</form>

		<h1>New Category</h1>

		<form:form action="/categories/new" method="post" modelAttribute="category">
			<form:label path="name">Name:
				<form:errors path="name"></form:errors>
				<form:input path="name"></form:input>
			</form:label>		

			<input type="submit" value="Create Category" />
		</form:form>

		<h1>New Product</h1>

		<form:form action="/products/new" method="post" modelAttribute="product">
			<form:label path="name">Name:
				<form:errors path="name"></form:errors>
				<form:input type="text" path="name"></form:input>
			</form:label>

			<form:label path="description">Description:
				<form:errors path="description"></form:errors>
				<form:input type="text" path="description"></form:input>
			</form:label>
			
			<form:label path="price">Price:
				<form:errors path="price"></form:errors>
				<form:input type="text" path="price"></form:input>
			</form:label>

			<input type="submit" value="Create Product" />
		</form:form>
	</body>
</html>