<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<head>
	<meta charset="UTF-8" />
	<title> Search Team Form</title>
	<link rel="stylesheet" href="${css}/style.css"/>
</head>	
<body>	
	<h1> Search BY TEAM ID </h1>
	<form action= "<%= ctx %>/member.do">
	Team 이름  : <input type="text" name="teamid">
	<input type="submit" value="전 송" />
	<input type="hidden" name="action" value="SEARCH" />
	<input type="hidden" name="page" value="searchTeamResult" />
</form>
</body>
</html>
