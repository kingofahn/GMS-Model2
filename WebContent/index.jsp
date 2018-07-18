<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath(); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%! 
	int count = 0;
%>
	<meta charset="UTF-8" />
	<title>HELLO</title>
	<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<%-- <%=  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) %> --%>
	현재 회원수 : <mark>	20 </mark> 명 
		
	<table class="width-full margin-auto height-1500">
	<tr>
		<th class="width-full height-500" colspan="2">
		<img id="width_height-full" class="margin-auto" src="img/home/main2.JPG" alt="">
		</th>
	</tr>
	<tr>
		<td class= "height-1000 width-60pt">
		<img class="width-full margin-auto height-full" src="img/home/mainbody.JPG" alt="">  </td>	
		<td> 
			<ul>
				<li> <a href="<%=ctx%>/member.do?action=move&page=joinForm">  Join  </a> </li>
				<li> <a href="<%=ctx%>/member.do?action=move&page=userLoginForm">  User Login </a> </li>
				<li> <a href="<%=ctx%>/member.do?action=LIST&page=memberlist">  Member List  </a> </li>
				<li> <a href="<%=ctx%>/member.do?action=COUNT&page=memberCount">  Member Count  </a> </li>
				<li> <a href="<%=ctx%>/member.do?action=move&page=searchTeamForm">  Search Team List  </a> </li>
				<li> <a href="<%=ctx%>/member.do?action=move&page=deleteForm">  Delete Member  </a> </li>
				<li> <a href="<%=ctx%>/member.do?action=move&page=updateForm">  Update Member  </a> </li>
			</ul>
		</td>
	</tr>
	<tr class="height-500">			
		<td colspan="2">
		<div>
		<img class="width-full margin-auto height-full" src="img/home/bottom.JPG" alt="">
		</div>
		</td>
	</tr>
	</table>
		
</body>
</html>