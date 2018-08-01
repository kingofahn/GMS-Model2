<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "domain.*" %>
<%@ page import = "service.*" %>
<jsp:include page="../common/head.jsp" />
<body>
<div id="wrapper">
	<div id="header">
	<jsp:include page="../common/titleBox.jsp" />
	<jsp:include page="../common/menuBox.jsp" />
</div>
	<div id="content">
	<% 	List<MemberBean> lst = MemberServiceImpl.getInstance().listMember(); %>
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
			<td> <%= m.getUserid() %> </td>
			<td> <%= m.getAge() %> </td>
			<td> <%= m.getRoll() %> </td>
			<td> <%= m.getSsn() %> </td>
			<td> <%= m.getPassword() %> </td>
			<td> <%= m.getGender() %> </td>
	</tr> 
			<% }  %>
	</table>
	<form>
	<input type="hidden" name="action" value="list" />
	<input type="hidden" name="page" value="joinResult" />
	</form>
		</div></div>
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp" />
	</div>
</body>
</html>