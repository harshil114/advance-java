<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Account</title>
</head>
<body>
<form action="delete" method="post">
	<h1>Delete your Account</h1>
	Email: <input type="email" name="email1"><br><br>
	Password: <input type="password" name="pass1"><br><br>
	<input type="submit" name="submit" value="Delete my Account"/><br><br>
	<a href="home.jsp">Home</a>
</form>
</body>
</html>