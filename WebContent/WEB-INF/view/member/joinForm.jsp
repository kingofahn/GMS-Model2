<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<head>
	<meta charset="UTF-8" />
	<title>Member Join </title>
	<link rel="stylesheet" href="${ctx}/resources/css/style.css"/>
</head>
<body>
<h1> Member Join </h1>
	<form name = "joinForm" action="<%= ctx %>/member.do" onsubmit="return validateForm()" method="get">
		NAME : <input type="text" name="name" placeholder="이름을  입력해주세요." /> <br>
		ID : <input type="text" name="userid" placeholder="ID를 입력해주세요." /> <input type="button" value="중복확인" ><br>
		Password : <input type="password" name="password" placeholder="비밀번호를  입력(8~20자)" />	<br>
		SSN : <input type="text" name="ssn" placeholder="생년월일 입력(ex900115-1)" /><br>
		<input type="submit" value="join">
		<input type="hidden" name="action" value="join" />
		<input type="hidden" name="page" value="joinResult" />
	</form>
</body>
</html>