<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<%@ page import = "service.*" %>
<%@ page import = "domain.*" %>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<div id="wrapper">
	<div id="header">
	<jsp:include page="../common/titleBox.jsp" />
	<jsp:include page="../common/menuBox.jsp" />
</div>
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
		</div>
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp" />
	</div>
</body>
</html>
