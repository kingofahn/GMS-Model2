<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title> 회원 탈퇴</title>
</head>
<body>
	<h1>회원탈퇴</h1>
	<form action= "<%= ctx %>/member.do">
		ID : <br />
		<input type="text" name ="userid"> <br>
		PASSWORD : <br>
		<input type="text" name = "password"> <br>
		<input type="submit" value="Delete">
		<input type="hidden" name="action" value="delete" />
		<input type="hidden" name="page" value="deleteResult" />

	</form>
	
</body>
</html>