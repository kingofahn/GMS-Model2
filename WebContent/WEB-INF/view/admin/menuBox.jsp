<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a id="moveHome"> HOME</a></li>
		<li><a id="moveAdminHome"> ADMIN HOME</a></li>
	</ul>
</div>
<script>

document.getElementById('moveHome').addEventListener('click',
		function() {
		router.move({context : '${ctx}',
					domain : 'common'
					});
		});
		
document.getElementById('moveAdminHome').addEventListener('click',
		function() {
		router.move({context : '${ctx}',
					domain : 'admin',
					action : 'list',
					page : 'main'});
		});


</script>
