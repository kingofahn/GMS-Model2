<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
<%@ page import="service.*" %>
<% 	String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Join result</title>
</head>

<body>
	<%
		MemberBean m = new MemberBean();
		m.setName(request.getParameter("name"));	
		m.setUserId(request.getParameter("userid"));
		m.setPassword(request.getParameter("password"));
		m.setSsn(request.getParameter("ssn"));
/* 		switch(request.getParameter("ssn").substring(7)){
		case "1" : m.setSex("남자") ; break;
		case "2" : m.setSex("여자") ; break;
		}	 */	
		MemberServiceImpl.getInstance().createMember(m);
	%>

	<a href="<%=ctx %> ../joinForm.jsp"> <input type="button" value="로그인 하러 가기"></a>
	<a href="<%=ctx %> ../../main.jsp"> <input type="button" value="홈페이지로 돌아가기"></a>
	
</body>
</html>