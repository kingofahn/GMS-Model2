<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
<table id="contentBoxTab">
	<tr id="contentBoxMeta">
		<th>ID</th>
		<th>NAME</th>
		<th>AGE</th>
		<th>GENDER</th>
		<th>ROLE</th>
		<th>TEAM</th>
	</tr>
	<c:forEach var="user" items="${memberList}" >
	<tr>
		<td>${user.userid}</td>
		<td><a class="username" id="${user.userid}">${user.name}</a></td>
		<td>${user.age}</td>
		<td>${user.gender}</td>
		<td>${user.roll}</td>
		<td>${user.teamid}</td>
	</tr>
	</c:forEach>
</table>
</div>
<script>
	document.getElementById('contentBoxMeta').className ='bgColorisYellow';
	var x = document.querySelectorAll('.username');
	for(i in x){
		x[i].style.color = 'blue';
		x[i].style.cursor = 'pointer';
		x[i].addEventListener('click',function(){
			location.href=
			'${ctx}/admin.do?action=retrieve&'
					+'page=memberDetail&userid='
					+this.getAttribute('id'); // 콜백함수 내부의 this는 최초의 하나만 가르킨다.
		}); 
	}
</script>