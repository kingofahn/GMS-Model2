<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<head>
	<meta charset="UTF-8" />
	<title>User Login</title>
	<link rel="stylesheet" href="${ctx}/resources/css/style.css"/>
</head>
<body>
	<h1> Login </h1>
	<form name = "userLoginForm" action="<%= ctx %>/member.do" onsubmit="return sendForm()" method="get">	
		User ID : <input type="text" name="userid" placeholder="ID를 입력해주세요."/> <br>
		Password : <input type="password" name="password" placeholder="비밀번호를  입력(8~20자)" />
		<input type="submit" value="submit" />
		<input type="hidden" name="action" value="login" />
		<input type="hidden" name="page" value="mypage" />
	</form>
</body>
</html>