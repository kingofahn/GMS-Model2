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
		<form id = "joinForm" name="joinForm">
		Member Join 
		NAME : <input type="text" name="name" placeholder="이름을  입력해주세요." /> <br>
		ID : <input type="text" name="userid" placeholder="ID를 입력해주세요." /> <input id="idCheckBtn" type="button" value="중복확인" ><br>
		Password : <input type="password" name="password" placeholder="비밀번호를  입력(8~20자)" />	<br>
		SSN : <input type="text" name="ssn" placeholder="생년월일 입력(ex900115-1)" /><br>
	
		소속팀
		<input type="radio" name="teamid" value="none" checked="checked"/> 없음
		<input type="radio" name="teamid" value="nolja"/> 걍놀자
		<input type="radio" name="teamid" value="jieunHouse"/> 지은하우스
		<input type="radio" name="teamid" value="turtleKing"/> 거북왕
		<input type="radio" name="teamid" value="coddingZzang"/> 코딩짱
		<br>
		
		프로젝트역할
		<select name="roll" id="roll">
		<option value="leader">팀장</option>
		<option value="front">프론트개발</option>
		<option value="back">백단개발</option>
		<option value="android">안드로이드개발</option>
		<option value="minfe">민폐</option>
		</select>
		<br>
		수강과목
		<input type="checkbox" name="subject" value="java" checked="checked"/> Java
		<input type="checkbox" name="subject" value="clang"/> C언어
		<input type="checkbox" name="subject" value="JSP"/>	JSP
		<input type="checkbox" name="subject" value="PHP"/> PHP
		<input type="checkbox" name="subject" value="nodejs"/> NodeJS
		<input type="checkbox" name="subject" value="linux"/> Linux
		<input type="checkbox" name="subject" value="html"/> HTML
		<input type="checkbox" name="subject" value="spring"/> Spring
		<br>
		<input id="joinFormBtn" type="button" value="MEMBER JOIN">
		</form>
		</div></div>
		<div id="footer">
			<jsp:include page="../common/footerBox.jsp" />
		</div>
	<script>
	document.getElementById('joinFormBtn')
	.addEventListener('click',function(){
		var x = service.nullChecker(
				[document.joinForm.name.value,
					document.joinForm.userid.value,
					document.joinForm.password.value,
					document.joinForm.ssn.value]); 
		if(x.checker){
			var form = document.getElementById('joinForm');
			form.action ="${ctx}/member.do";
			form.method ="post";  /* get으로 하면 노출됨 */
			var json = [{name:'action', value:'join'}, 
						{name:'gender'}, 
						{name:'age'}];
            for(var i in json){
                var node = document.createElement('input');
                node.setAttribute('type', 'hidden');
                node.setAttribute('name', json[i].name);
                node.setAttribute('value', json[i].value);
                form.appendChild(node);
            }
			member.join(form.ssn.value);
 			form.gender.value=member.getGender();
			form.age.value=member.getAge(); 
			form.submit();
		} else {
			alert(x.text);			
		}
	});
	</script>
</body>
</html>