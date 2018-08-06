<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
	<div id="searchBox">
		<select name="searchOption" id="searchOption">
			<option value="none"> Keyword </option>
			<option value="userid"> ID </option>
			<option value="name"> NAME</option>
			<option value="teamid">TEAM </option>
			<option value="roll">ROLL </option>
			<option value="gender">GENDER </option>
		</select>
		<input name="searchWord" id="searchWord" type="text" placeholder="Insert Keyword" />
		<input type="button" id="searchBtn" value="Search" />
	</div>
	<table id="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>ID</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>GENDER</th>
			<th>ROLE</th>
			<th>TEAM</th>
		</tr>
		<c:forEach var="user" items="${getList}" >
		<tr>
			<td>${user.userid}</td>
			<td><a class="username" id="${user.userid}">${user.name}</a></td>
			<td>${user.age}</td>
			<td>${user.gender}</td>
			<td>${user.roll}</td>
			<td>${user.teamid}</td>
		</tr>
				
		</c:forEach>
		<tr>
			<td colspan="6" >
				<!--  조회 인원 : ${count} 전체인원 : ${memberList.size()} 명 --> 
				<ul class="pageBox">
					<c:forEach begin="${beginPage}" 
					end="${endPage}" step="1" varStatus="i">
						<li>
							<a href="#"> ${i.index} </a>	
						</li>
					</c:forEach>
					<c:if test="${count gt 25}">
						<li>다음▶</li>
					</c:if>
				</ul>
			</td> 
		</tr>
	</table>
</div>
<script>
	admin.main('${ctx}');
</script>