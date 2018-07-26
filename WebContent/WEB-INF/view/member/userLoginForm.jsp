<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<h1>Login</h1>
	<form id="userLoginForm">
		User ID : <input type="text" name="userid" placeholder="ID를 입력해주세요." /><br> 
		Password : <input type="password" name="password" placeholder="비밀번호를  입력(8~20자)" /> 
		<input id="loginFormBtn" type="button" value="전송" /> 
		<input type="hidden" name="action" 	value="login" /> 
		<input type="hidden" name="page" value="mypage" />
	</form>

	<script>
	document.getElementById('loginFormBtn')
	.addEventListener('click',function(){
		var member = new Member();
		var form =document.getElementById('userLoginForm');
		form.action="${ctx}/member.do";
		form.method="post";
		member.setUserid(form.userid.value);
		member.setPassword(form.password.value);
		if(service.loginValidation(member)){
			form.submit();
		}
	});
	</script>
</body>
</html>