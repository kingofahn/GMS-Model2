<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a href="${ctx}"> HOME</a></li>
		<li><a onclick="move('member','move','memberlist')"> 회원목록</a></li>
		<li><a onclick="move('member','move','searchIDForm')">회원검색</a></li>
		<li><a onclick="move('member','move','searchTeamForm')">팀검색</a></li>
	</ul>
</div>

<script>
function move(domain,action,page) {
	console.log('콘솔 테스트 성공!!');
	alert('클릭 테스트 성공!!  ${ctx}' );  /* alert는 자바의 sysout 같음  */
	location.href = 
				"${ctx}/"+domain+
					".do?action="+action+
							"&page="+page;
}
</script>

<script>
	function sendForm() {
        return true;
    }
</script>