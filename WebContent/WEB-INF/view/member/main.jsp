<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
<div id="wrapper">
	<div id="header">
	<jsp:include page="../common/titleBox.jsp" />
	<jsp:include page="../common/menuBox.jsp" />
	</div>

	<div id="content">
		<table id="mypage-table">  
		<tr>
			<th  rowspan='3'>PHOTO </th> 
			<th>ID</th>
			<th colspan='2'>${user.userid} </th>
		</tr>
		<tr>
			<th>NAME</th>
			<th colspan='2'>${user.name}</th>
		</tr>
		<tr>
			<th>PASSWORD</th>
			<th colspan='2'>************</th>
		</tr>
		<tr>
			<th>AGE</th>
			<th>${user.age}</th>
			<th>TEAM</th>
			<th>${user.teamid}</th>
		</tr>
		<tr>
			<th>GENDER</th>
			<th>${user.gender}</th>
			<th>ROLL</th>
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
							action : 'move', 
							page : 'updateForm'
				});
			});
			
	document.getElementById('myPageMoveToDelete').addEventListener('click',
			function() {
			router.move({context : '${ctx}',
				domain : 'member',
				action : 'move', 
				page : 'deleteForm'
						});
			});

	</script>
</body></html>
