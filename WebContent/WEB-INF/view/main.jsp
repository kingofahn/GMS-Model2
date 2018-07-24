<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="common/titleBox.jsp"/>
		<jsp:include page="common/loginBox.jsp"/>
		<jsp:include page="common/menuBox.jsp"/>
	</div> <!-- header end -->
	<div id="content">
		<jsp:include page="common/contentBox.jsp"/>
	</div> <!-- content end -->
	<div id="footer">
		<jsp:include page="common/footerBox.jsp"/> 
	</div> <!-- footer end -->
</div> <!-- wrapper end -->

<script>
function move(domain,action,page) {
	console.log('콘솔 테스트 성공!!');
	alert('클릭 테스트 성공!!  ${ctx}' );  /* alert는 자바의 sysout 같음  */
	location.href = 
				"${ctx}/"+domain+
					".do?action="+action+
							"&page="+page;
}
	function sendForm() {
        return true;
    }
</script>

</body>
</html>



