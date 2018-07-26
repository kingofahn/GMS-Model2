var router = (()=>{ /*t,domain, action, page*/
	return {move:x=>{  
		location.href = 
			x[0] + '/' 
			+ x[1]
			+ '.do?action='+x[2]
			+ '&page='+x[3]
		}};  /* 이것이 클로져임, 키값:value 이 것이 JSON임 */
})();

var service = (()=>{
	return{
		loginValidation : x=>{
			var form = document.getElementById('userLoginForm');
			if (x.getUserid()==='') {
				alert("Please provide your ID");
				return false;
			} else if (x.getPassword() === '') {
				alert("Please provide your Password!");
				return false;
			} else {
				return true;
			}	
		},
		joinValidation : x=>{
			var form =document.getElementById('joinForm');
			if (x.getName()==='') {
				alert("Please provide your Name!");
				return false;
			} else if (x.getUserid()==='') {
				alert("Please provide your ID!")
				return false;
			} else if (x.getPassword() === '') {
				alert("Please provide your Password!")
				return false;
			} else if (x.getSsn() === '') {
				alert("Please provide your Social Security Number!")
				return false;
			} else {
				return true;
			}
		}
	};
})();

function Member() {
	var name, userid, ssn, password;
	this.setName = function(x) {
		this.name = x;
	}
	this.setUserid = function(x) {
		this.userid = x;
	}
	this.setSsn = function(x) {
		this.ssn = x;
	}
	this.setPassword = function(x) {
		this.password = x;
	}
	this.getUserid = function(x) {
		return this.userid;
	}
	this.getSsn = function(x) {
		return this.ssn;
	}
	this.getPassword = function(x) {
		return this.password;
	}
	this.getName = function(x) {
		return this.name;
	}
}