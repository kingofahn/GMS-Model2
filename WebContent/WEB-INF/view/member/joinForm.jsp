<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Member Join </title>
	
</head>
<body>
<form action= "<%= ctx %>/member.do">
	<h1> 회원 가입 </h1>

	<table>
		<tr>
			<td>NAME</td>
			<td> <input type="text" name="name" placeholder="이름을  입력해주세요." /></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="userid" placeholder="ID를 입력해주세요." /> 
				<input type="button" value="중복확인" ></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" placeholder="비밀번호를  입력(8~20자)" /></td>	
		</tr>
		<tr>
			<td>SSN</td>
			<td><input type="text" name="ssn" placeholder="생년월일 입력(ex900115-1)" /></td>
		</tr>
	</table>
	<input type="hidden" name="action" value="move" />
	<input type="hidden" name="page" value="joinResult" />
	<input type="submit" value="join">
	
</form>
</body>
</html>