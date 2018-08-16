<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="content-box">
		<table id="mypage-table">  
		<tr>
			<td  rowspan='3' colspan='2'>
			<img src="${img}/upload/${image.imgname}.${image.extension}">
			</td> 
			<td>아이디</td>
			<td id="userid"> ${user.userid} </td>
		</tr>
		<tr>
			<td>이름</td>
			<td colspan='2'>${user.name}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td colspan='2'>************</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${user.age}</td>
			<td>팀명</td>
			<td>${user.teamid}</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${user.gender}</td>
			<td>역할</td>
			<td>${user.roll}</td>
		</tr>
	</table>
	<div id="mypage-bottom">
		 <a id="myPageMoveToUpdate"> UPADATE FORM</a> 
		 <a id="myPageMoveToDelete"> DELETE FORM </a> 
	</div>
	
	</div>
	<script>
		member.main('${ctx}')
	</script>
