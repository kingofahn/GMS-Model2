<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">

<head>
		<link rel="stylesheet" href="${css}/style.css"/>
	<meta charset="UTF-8" />
	<title> Search BY ID</title>
</head>

<body>
	<h1> Search BY ID </h1>
	<form action= "<%= ctx %>/member.do">
		User ID <input type="text" name="uid" />
	<input type="hidden" name="action" value="RETRIEVE" />
	<input type="hidden" name="page" value="searchIDResult" />
	<input type="submit" value="전송" />
		
	</form>
</body>
</html>
