<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<head>
	<meta charset="UTF-8" />
	<title> Search BY ID</title>
	<link rel="stylesheet" href="${css}/style.css"/>
</head>

<body>
	<h1> Update by Member ID </h1>
	<form action= "<%= ctx %>/member.do">
		User ID <input type="text" name="uid" />
		  <select name="teamid">
		    <option value="ATEAM">ATEAM</option>
		    <option value="BTEAM">BTEAM</option>
		    <option value="CTEAM">BTEAM</option>
		    <option value="DTEAM">BTEAM</option>
		  </select>
		    <select name="roll">
		    <option value="팀장">팀장</option>
		    <option value="팀원">팀원</option>
		  </select>
		<input type="hidden" name="action" value="updateMemberInformation" />
		<input type="hidden" name="page" value="" />
		<input type="submit" value="전송" />
	</form>
</body>
</html>
