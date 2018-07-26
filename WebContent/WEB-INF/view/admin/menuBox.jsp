<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a id="moveHome"> HOME</a></li>
		<li><a id="moveMemberlist"> 회원목록</a></li>
		<li><a id="moveSearchidform">회원검색</a></li>
		<li><a id="moveSearchteamform">팀검색</a></li>
	</ul>
</div>
<script>
document.getElementById('moveHome').addEventListener('click',
		function() {
		router.move(['${ctx}','common','','']);
		});
document.getElementById('moveMemberlist').addEventListener('click',
		function() {
		router.move(['${ctx}','member','move','memberlist']);
		});
document.getElementById('moveSearchidform').addEventListener('click',
		function() {
		router.move(['${ctx}','member','move','searchIDForm']);
		});
document.getElementById('moveSearchteamform').addEventListener('click',
		function() {
		router.move(['${ctx}','member','move','searchTeamForm']);
		});
</script>
