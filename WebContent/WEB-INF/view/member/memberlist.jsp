<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<%@ page import = "java.util.*" %>
<%@ page import = "domain.*" %>
<%@ page import = "service.*" %>
<head>
	<meta charset="UTF-8" />
	<title>Member List</title>
	<link rel="stylesheet" href="${css}/style.css"/>
</head>
<body>
<div id="wrapper">
	<% 	List<MemberBean> lst = MemberServiceImpl.getInstance().listMember(); %>
	<h1>  Member List</h1>
	<table> 
	<tr> 
		<th>이름 </th>
		<th>TEAM ID</th>  
		<th>ID</th> 
		<th>AGE</th> 
		<th>ROLL</th> 
		<th>SSN</th>
		<th>PASSWORD</th>
		<th>GENDER</th>
	</tr>
	<%	
		for(MemberBean m : lst){
		%> <tr> 
			<td> <%= m.getName() %> </td>
			<td> <%= m.getTeamid() %> </td>
			<td> <%= m.getUserId() %> </td>
			<td> <%= m.getAge() %> </td>
			<td> <%= m.getRoll() %> </td>
			<td> <%= m.getSsn() %> </td>
			<td> <%= m.getPassword() %> </td>
			<td> <%= m.getGender() %> </td>
			</tr> 
			<% }  %>
	</table>
	<form action= "<%= ctx %>/member.do">
	<input type="hidden" name="action" value="list" />
	<input type="hidden" name="page" value="joinResult" />
	</form>
</div>
</body>
</html>