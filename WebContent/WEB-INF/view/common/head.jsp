<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8" />
	<title>Main</title>
	<link rel="stylesheet" href="${css}/style.css"/>
	<script>
	var common = new(function(){
		this.move = function(domain,action,page){
			location.href ="${ctx}/"+domain+".do?action="+action+"&page="+page;	
			}
	});
	var member = new(function(){
		var userid,ssn,password;
		this.setUserid = function(x){
			this.userid = x;
		}
		this.setSsn = function(x){
			this.ssn = x;
		}
		this.setPassword = function(x){
			this.password = x;
		}
		this.getUserid = function(x){
			return this.userid;
		}
		this.getSsn = function(x){
			return this.ssn;
		}
		this.getPassword = function(x){
			return this.password;
		}
		this.loginValidation = function(){
			 /*function 은 무조건 return을 줘야 한다. reuturn하고 아무것도 입력하지 않으면 void  */
			if(this.userid===''){
	           alert("Please provide your ID");
	           return false;
	        } else if(this.password===''){
	           alert("Please provide your Password!" );
	           return false;
	        } else{
	        	return true;
			}
		}
	});
	</script>
</head>
