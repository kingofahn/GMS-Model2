<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="moveLoginForm"> LOGIN </a>  <!--  ""를 하는 이유는 js에서는 attribute 속성값을 준다 --> 
	&nbsp;&nbsp;&nbsp; 
	<a id="moveJoinForm">JOIN</a>
</div>


<script>
document.getElementById('moveLoginForm')
	.addEventListener('click',function(){
	common.move('member','move','userLoginForm');
});

document.getElementById('moveJoinForm')
.addEventListener('click',function(){
common.move('member','move','joinForm');
});

</script>