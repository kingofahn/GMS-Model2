<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<head>
	<meta charset="UTF-8" />
	<title>Member Join </title>
	<link rel="stylesheet" href="${css}/style.css"/>
</head>
<body>
<h1> Member Join </h1>
	<form id = "joinForm">
		NAME : <input type="text" name="name" placeholder="이름을  입력해주세요." /> <br>
		ID : <input type="text" name="userid" placeholder="ID를 입력해주세요." /> <input id="idCheckBtn" type="button" value="중복확인" ><br>
		Password : <input type="password" name="password" placeholder="비밀번호를  입력(8~20자)" />	<br>
		SSN : <input type="text" name="ssn" placeholder="생년월일 입력(ex900115-1)" /><br>
		<input id="joinFormBtn" type="submit" value="MEMBER JOIN">
		<input type="hidden" name="action" value="join" />
		<input type="hidden" name="page" value="joinResult" />
	</form>
	
<script>

	document.getElementById('idCheckBtn').
	addEventListener('click',function(){
		var form = document.getElementById('joinForm');
		if(MemberServiceImpl.getInstance().findById(form.userid.value).getUserId==null){
			alert("사용가능한 ID 입니다.")
		} else{
			alert("중복된 ID 입니다.")
		form.submit();
		}});


	document.getElementById('joinFormBtn')
	.addEventListener('click',function(){
		var form = document.getElementById('joinForm');
		form.action ="${ctx}/member.do";
		form.method ="post";  /* get으로 하면 노출됨 */
		if(form.name.value==""){
			alert("Please provide your Name");
			document.name.focus();
			return false;
		}
		if(form.userid.value==""){
			alert("Please provide your User ID");
			document.userid.focus();
			return false;
		}
		if(form.password.value==""){
			alert("Please provide your User Password");
			document.password.focus();
			return false;
		}
		if(form.ssn.value==""){
			alert("Please provide your User Social Security Number");
			document.ssn.focus();
			return false;
		}
		form.submit();
	});
</script>
</body>
</html>