<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
<h2>Login Page</h2>
<form action="loginservlet" method="post" >
<table>
<tr><td>User Name<input type="text" name=username></td></tr>
<tr><td>Password<input type="password" name=password></td></tr>
<tr><td><input type="submit" value=Login> <input type="reset" value=Reset></td></tr>
</table>
</form>

</body>
</html>