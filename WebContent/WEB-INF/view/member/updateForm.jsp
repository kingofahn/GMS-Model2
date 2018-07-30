<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/head.jsp" />
        <h1>◆Update◆</h1>
		<div id="content-box">
		<form id="updateForm" name="updateForm">
                <table>
                    <tr>
                        <td id="mypage-img" rowspan="3" colspan="2"></td>
                        <td><h5>ID</h5></td>
                        <td><h5>${user.userid}</h5></td>
                    </tr>
                    <tr>
                        <td><h5>이름 </h5></td>
                        <td><h5>${user.name}</h5></td>
                    </tr>
                    <tr>
                        <td><h5>비밀번호</h5></td>
                        <td>
                            <input type="text" name="password" placeholder="********" >
                        </td>
                    </tr>
                    <tr>
                        <td><h5>성별</h5></td>
                        <td><h5>${user.gender}</h5></td>
                        <td><h5>팀</h5></td>
                        <td>
                            <select name="teamid" id="teamid">
                                <option value="" selected="selected">NONE</option>
                                <option value="nolja">야놀자</option>
                                <option value="jieunHouse">지은집</option>
                                <option value="turtleKing">터틀킹</option>
                                <option value="codingZzang">코딩스타</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><h5>나이</h5></td>
                        <td><h5>${user.age}</h5></td>
                        <td><h5>역할 (현재역할 : ${user.roll})</h5></td>
                        <td>
		   	            <input type="radio" id="roll_1" name="roll" value="leader" /> 팀장
					  	<input type="radio" id="roll_2" name="roll" value="front" /> 프론트개발
						<input type="radio" id="roll_3" name="roll" value="back" /> 백단개발
						<input type="radio" id="roll_4" name="roll" value="android" /> 안드로이드개발
						<input type="radio" id="roll_5" name="roll" value="minfe" /> 민폐
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="action" 	value="update" />
                <input type="hidden" name="userid" value="${user.userid}">
                <input type="button" id="updateConfirmBtn" value="Update!!!" />
			</form>
        </div>
<script>

	var form = document.getElementById("updateForm");
	var team = document.getElementById("teamid");
	for(var i = 0; i<team.options.length;i++){
	    if(team.options[i].value==='${user.teamid}'){
	        team.options[i].setAttribute("selected","selected");
	    }
	}
	form.teamid.setAttribute("selected","selected");
	
	for(var i=1; i<=5; i++){
		if(document.getElementById('roll_'+i).value==='${user.roll}'){
		document.getElementById('roll_'+i).checked = true;
		} 
	}
	
	document.getElementById("updateConfirmBtn").addEventListener('click',function(){
		var x = service.nullChecker(
				[document.updateForm.password.value,
					document.updateForm.teamid.value,
					document.updateForm.roll.value
					]); 
		
		if(x.checker){	
		form.action ="${ctx}/member.do";
		form.method ="post";  /* get으로 하면 노출됨 */
		form.submit();
		} else {
			alert(x.text);			
		}
	});
	
</script>