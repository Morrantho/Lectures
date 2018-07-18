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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
    <link rel="stylesheet" href="/css/customers.css">
    <title>Page Title</title>
</head>

<body>
    <div class="container">
        <div class="nav">
            <a href="">
                <button class="btn btn-default">Dashboard</button>
            </a> |
            <a href="">
                <button class="btn btn-default">Products</button>
            </a>
            <a href="">
                <button class="btn btn-default">Orders</button>
            </a>
            <a href="">
                <button class="btn btn-default">Customers</button>
            </a>
            <a href="">
                <button class="btn btn-default">Settings</button>
            </a>
        </div>
        <hr>
        <div class="box">
            <h1>
                <b>Add A New Customer</b>
            </h1>
            <hr>
            <div class="form-group">
                <form:form action="/customers" method="POST" modelAttribute="customer">
                    <form:label path="name">Name:
                        <form:errors path="name"></form:errors>
                        <form:input path="name"></form:input>
                    </form:label>

                    <input type="submit" value="Create Customer" class="btn btn-success" />
                </form:form>
            </div>
        </div>
        <div class="box">
            <table class="table table-hover">
                <tr class="info">
                    <th>Customer Name</th>
                    <th>Created Date</th>
                    <th>Actions</th>
                </tr>

                <c:forEach items="${customers}" var="i">
                    <tr>
                        <td>${i.name}</td>
                        <td>${i.createdAt}</td>
                        <td>
                            <form method="post" action="">
                                <a href="/customers/${i.id}/delete" role="button" class="btn btn-danger">Remove</a>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>

</body>

</html>