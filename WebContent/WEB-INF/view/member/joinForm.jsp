<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<h1> Member Join </h1>
	<form id = "joinForm">
		NAME : <input type="text" name="name" placeholder="이름을  입력해주세요." /> <br>
		ID : <input type="text" name="userid" placeholder="ID를 입력해주세요." /> <input id="idCheckBtn" type="button" value="중복확인" ><br>
		Password : <input type="password" name="password" placeholder="비밀번호를  입력(8~20자)" />	<br>
		SSN : <input type="text" name="ssn" placeholder="생년월일 입력(ex900115-1)" /><br>
		<input id="joinFormBtn" type="button" value="MEMBER JOIN">
		<input type="hidden" name="action" value="join" />
		<input type="hidden" name="page" value="joinResult" />
	</form>
<script>
	document.getElementById('joinFormBtn')
	.addEventListener('click',function(){
		var member = new Member();
		var form = document.getElementById('joinForm');
		form.action ="${ctx}/member.do";
		form.method ="post";  /* get으로 하면 노출됨 */
		member.setName(form.name.value);
		member.setUserid(form.userid.value);
		member.setPassword(form.password.value);
		member.setSsn(form.ssn.value);
		if(service.joinValidation(member)){
			form.submit();
		}});
</script>
</body>
</html>