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
	<form id="deleteForm" name="deleteForm">
		비밀번호 재입력 
		<input type="password" name="password" id="password" placeholder="비밀번호를  입력(8~20자)" />
		<input type="button" id="deleteConfirmBtn" value="Delete!!!" />
	</form>
	</div></div>
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp" />
	</div>
	<script>
	var form = document.getElementById("deleteForm");
	document.getElementById("deleteConfirmBtn").addEventListener('click',function(){
		if("${user.password}"===form.password.value){
			form.action ="${ctx}/member.do";
			form.method ="post";  /* get으로 하면 노출됨 */
			var node = document.createElement('input');
				node.setAttribute('type','hidden');
				node.setAttribute('name','action')
				node.setAttribute('value','delete')
				form.appendChild(node);
			form.submit();
		} else{
			alert('Wrong Password');
		}
	});
	</script>
	</body></html>