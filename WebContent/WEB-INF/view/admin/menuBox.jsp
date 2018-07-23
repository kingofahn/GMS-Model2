<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=application.getContextPath() %>"/>
<div id="menu-box">
	<ul id="menu">
		<li><a href="${ctx}"> HOME</a></li>
		<li><a href="${ctx}/member.do?action=LIST&page=memberlist">회원목록</a></li>
		<li><a href="${ctx}/member.do?action=move&page=searchIDForm">회원검색</a></li>
		<li><a href="${ctx}/member.do?action=move&page=searchTeamForm">팀검색</a></li>
	</ul>
</div>