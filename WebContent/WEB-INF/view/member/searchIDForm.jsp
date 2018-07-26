<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<h1> Search BY ID </h1>
	<form id= "findByid">
	User ID <input type="text" name="uid" />
	<input type="hidden" name="action" value="RETRIEVE" />
	<input type="hidden" name="page" value="searchIDResult" />
	<input id="findByidBtn" type="button" value="전송" />
	</form>
<script>		

</script>	
</body>
</html>
