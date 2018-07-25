<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a href="${ctx}"> HOME</a></li>
		<li><a onclick="common.move('member','move','memberlist')"> 회원목록</a></li>
		<li><a onclick="common.move('member','move','searchIDForm')">회원검색</a></li>
		<li><a onclick="common.move('member','move','searchTeamForm')">팀검색</a></li>
	</ul>
</div>
