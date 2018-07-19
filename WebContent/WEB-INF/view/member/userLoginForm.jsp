<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<html>
<head>
	<title>User Login</title>
	<link rel="stylesheet" href="../../css/style.css">
</head>
<body id="login_box">
	<h1> Login </h1>
	<form action= "<%= ctx %>/member.do">
		User ID : <br>
		<input type="text" name="userid" /><br>  <!-- value를 넣지 않아도 String null ""을 갖고 있는다. -->
		Password : <br>
		<input type="password" name="password" />
		<br><br>
		<input type="submit" value="전 송" /> <!--버튼을 눌러야만 값이 생성된다. -->
		<input type="hidden" name="action" value="login" />
		<input type="hidden" name="page" value="userLoginForm" />
	</form>
</body>
</html>