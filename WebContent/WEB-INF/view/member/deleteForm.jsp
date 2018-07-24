<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<head>
	<meta charset="UTF-8" />
	<title> Member Withdrawal </title>
	<link rel="stylesheet" href="${css}/style.css"/>
</head>
<body>
	<h1> Member Withdrawal </h1>
	<form action="<%= ctx %>/member.do" onsubmit="return validateForm()" method="get" >
		ID : <input type="text" name ="userid" placeholder="ID를 입력해주세요." /><br />
		PASSWORD : <input type="password" name="password" placeholder="비밀번호를  입력(8~20자)"/>
		<input type="submit"  value="Delete"/>
		<input type="hidden" name="action" value="delete" />
		<input type="hidden" name="page" value="deleteResult" />
	</form>
</body>
</html>