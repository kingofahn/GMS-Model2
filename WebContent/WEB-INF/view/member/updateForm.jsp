<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title> Password Update </title>
</head>
<body>
	<h3> Password Update </h3>
	<form action= "<%= ctx %>/member.do">
		User ID : <br>
		<input type="text" name="userid" > <br>
		Old password : <br>
		<input type="password" name="password"> <br>
		New password : <br>
		<input type="password" name="newpassword"> <br>
		<input type="hidden" name="action" value="UPDATE" />
		<input type="hidden" name="page" value="updateResult" />
		<input type="submit" value="update"> <br>
	</form>

</body>
</html>





