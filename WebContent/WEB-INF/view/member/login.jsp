<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="contentBox">
	<div id="loginFormLayout" style="width: 250px;margin: 50px auto;border:5px solid black">
		<h1 >로그인</h1>
			<form id="userLoginForm" name="userLoginForm">
				User ID : <input type="text" name="userid" placeholder="Insert your ID" /><br> 
				Password : <input type="password" name="password" placeholder="Insert your password" /> 
				<input id="loginFormBtn" type="button" value="전송" /> 
				<input type="hidden" name="action" 	value="login" /> 
			</form>
	</div>
</div> 
	<script>
	document.getElementById('loginFormBtn')
	.addEventListener('click',function(){
		var x = service.nullChecker(
				[document.loginForm.userid.value,
					document.loginForm.password.value]);
		if(x.checker){
			var form = document.getElementById('userLoginForm');
			form.action = "${ctx}/member.do" ;
			form.method = "post";
			form.submit();	
		}else{
			alert(x.text);
		}
	});
	</script>
</body>
