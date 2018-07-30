<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<%@ page import = "service.*" %>
<%@ page import = "domain.*" %>
<head>
	<meta charset="UTF-8" />
	<title> Search ID Result</title>
	<link rel="stylesheet" href="${css}/style.css"/>
</head>
<body>
	<% 
	MemberBean m = MemberServiceImpl.getInstance().findById(request.getParameter("uid"));
	%>
	<table>
		<tr> 
			<th>이름 </th>
			<th>TEAM ID</th>  
			<th>ID</th> 
			<th>AGE</th> 
			<th>ROLL</th> 
			<th>SSN</th>
		</tr>
		<tr> 
			<td> <%= m.getName() %> </td>
			<td> <%= m.getTeamid() %> </td>
			<td> <%= m.getUserid() %> </td>
			<td> <%= m.getAge() %> </td>
			<td> <%= m.getRoll() %> </td>
			<td> <%= m.getSsn() %> </td>
		</tr> 
	</table>
</body>
</html>
