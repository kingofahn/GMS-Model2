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
	<form>
	Team 이름  : <input type="text" name="teamid">
	<input type="submit" value="전 송" />
	<input type="hidden" name="action" value="SEARCH" />
	<input type="hidden" name="page" value="searchTeamResult" />
</form>
	</div></div>
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp" />
	</div>
</body>
</html>
