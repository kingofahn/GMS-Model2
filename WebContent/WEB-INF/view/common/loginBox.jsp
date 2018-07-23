<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=application.getContextPath() %>"/>

<div id="login-box">
	<a href="${ctx}/member.do?action=move&page=userLoginForm"> LOGIN </a> &nbsp;&nbsp;&nbsp; 
	<a href="${ctx}/member.do?action=move&page=joinForm">JOIN</a>
</div>
		