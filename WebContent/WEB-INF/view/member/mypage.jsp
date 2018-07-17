<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date" %>
<%!	String name =""; %>

<head>
	<meta charset="UTF-8" />
	<title>HELLO</title>
	<link rel="stylesheet" href="../../css/style.css" />

</head>
<body>
	<%= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) %>
	<table class="width-full margin-auto height-2000">
	<tr>
		<th class="width-full height-500" colspan="2">
		<img id="width_height-full" class="margin-auto" src="../../img/home/main2.JPG" alt="">
		</th>
	</tr>
	<tr>
		<td class= "height-1000 width-60pt">
		<img class="width-full margin-auto height-full" src="../../img/home/mainbody.JPG" alt="">  </td>	
		<td> <a href="../home/main.html"> 
		<img id="width_height-full" class="margin-auto" src="../../img/mypage/loginSuccess.JPG" alt="">
		</a> </td>
	</tr>
	<tr class="height-500">			
		<td colspan="2">
		<div>
		<img class="width-full margin-auto height-full" src="../../img/home/bottom.JPG" alt="">
		</div>
		</td>
	</tr>
	</table>
		
</body>
</html>