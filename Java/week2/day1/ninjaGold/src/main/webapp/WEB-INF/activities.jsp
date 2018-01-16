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

		<style>
			.locations{
				display: flex;
			}

			.activities{
				height: 50vh;
				overflow: scroll;
			}
		</style>
	</head>

	<body>
		<h1>Your Gold: ${ gold }</h1>

		<div class="locations">
			<form action="/activities/new" method="post">
				<h1>Farm</h1>
				<h4>(earns 10-20 gold)</h4>
				<input type="submit" name="farm" value="Find Gold!" />
			</form>

			<form action="/activities/new" method="post">
				<h1>Cave</h1>
				<h4>(earns 5-10 gold)</h4>
				<input type="submit" name="cave" value="Find Gold!"/>
			</form>

			<form action="/activities/new" method="post">
				<h1>House</h1>
				<h4>(earns 2-5 gold)</h4>
				<input type="submit" name="house" value="Find Gold!"/>
			</form>

			<form action="/activities/new" method="post">
				<h1>Casino</h1>
				<h4>(earns or takes 0-50 gold)</h4>
				<input type="submit" name="casino" value="Find Gold!"/>
			</form>
		</div>

		<div class="activities">
			<h1>Activities:</h1>

			<c:forEach items="${ activities }" var="activity">
				<p>${ activity.text }</p>
			</c:forEach>
		</div>
	</body>
</html>