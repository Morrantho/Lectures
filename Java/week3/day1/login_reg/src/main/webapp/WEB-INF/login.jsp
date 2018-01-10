<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Page</title>
</head>

<body>
	<h1>Login</h1>
	<form method="POST" action="/login">
		<p>
			<label for="username">Username</label>
			<input type="text" id="username" name="username" />
		</p>
		<p>
			<label for="password">Password</label>
			<input type="password" id="password" name="password" />
		</p>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="Login!" />
	</form>
</body>

</html>