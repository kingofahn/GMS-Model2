<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="domain.*" %>
<head>
	<meta charset="UTF-8" />
	<title>MY PAGE</title>
	<link rel="stylesheet" href="${css}/style.css"/>
</head>
<body>
	<% 	MemberBean user = (MemberBean)request.getAttribute("user");%>
	<h1> <%= user.getName() %> 님의 My Page</h1>
</body>
