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
	<form id= "findByid">
	User ID <input type="text" name="userid" />
	<input type="hidden" name="action" value="RETRIEVE" />
	<input type="hidden" name="page" value="searchIDResult" />
	<input id="searchIDFormBtn" type="button" value="전송" />
	</form>
	</div></div>
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp" />
	</div>
	<script>		
		
	</script>	
</body>
</html>
