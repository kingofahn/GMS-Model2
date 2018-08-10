<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">
	<div id="content">
		<table id="mypage-table">  
		<tr>
			<th  rowspan='3'>사진 </th> 
			<th>아이디</th>
			<th colspan='2'> ${user.userid} </th>
		</tr>
		<tr>
			<th>이름</th>
			<th colspan='2'>${user.name}</th>
		</tr>
		<tr>
			<th>비밀번호</th>
			<th colspan='2'>************</th>
		</tr>
		<tr>
			<th>나이</th>
			<th>${user.age}</th>
			<th>팀명</th>
			<th>${user.teamid}</th>
		</tr>
		<tr>
			<th>성별</th>
			<th>${user.gender}</th>
			<th>역할</th>
			<th>${user.roll}</th>
		</tr>
	</table>
	<div id="mypage-bottom">
		 <a id="myPageMoveToUpdate"> UPADATE FORM</a> 
		 <a id="myPageMoveToDelete"> DELETE FORM </a> 
	</div>
	</div></div>
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp" />
	</div>
	<script>
	document.getElementById('myPageMoveToUpdate').addEventListener('click',
			function() {
				router.move({context : '${ctx}',
							domain : 'member',
							action : 'modify', 
							page : 'modify'
				});
			});
			
	document.getElementById('myPageMoveToDelete').addEventListener('click',
			function() {
			router.move({context : '${ctx}',
				domain : 'member',
				action : 'remove', 
				page : 'remove'
						});
			});
	</script>
