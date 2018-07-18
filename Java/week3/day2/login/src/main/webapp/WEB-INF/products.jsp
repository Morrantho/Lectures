<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" rel="stylesheet"  integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"crossorigin="anonymous">
    <link rel="stylesheet" href="/css/products.css">
    <title>Products</title>
</head>
<body>
    <form:form method="POST" action="/products" modelAttribute="product">
        <form:label path="name">Name
            <br>
            <form:input path="name" class="form-control"></form:input>
            <br>
            <form:errors path="name"></form:errors>
        </form:label>

        <form:label path="img">Image
            <br>
            <form:input path="img" class="form-control"></form:input>
            <br>
            <form:errors path="img"></form:errors>
        </form:label>

        <form:label path="description">Description
            <br>
            <form:input path="description" class="form-control"></form:input>
            <br>
            <form:errors path="description"></form:errors>
        </form:label>

        <form:label path="quantity">Quantity
            <br>
            <form:input path="quantity" class="form-control"></form:input>
            <br>
            <form:errors path="quantity"></form:errors>
        </form:label>

        <!-- change this to success later -->
        <button type="submit" class="btn btn-info">Create Product</button>
    
    </form:form>

    <c:forEach items="${products}" var="product">
        <img src="${product.img}" />
        <p>(${product.quantity}) left</p>
    </c:forEach>
</body>
</html>