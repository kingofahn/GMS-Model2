var router = (()=>{ /* t,domain, action, page */
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
		nullChecker : x=>{
			var i = 0;
			var j = {
					checker : true,
					text : 'Please provide your Information!'
					};
			for (i in x){
				if(x[i]===''){
					j.checker = false;
				}
			}
			return j;
		}
	}
})();

var member = (()=> {
	var _name, _userid, _ssn, _password, _gender, _age, _roll, _teamid;
	var setName = (name)=> {this._name = name;}
	var setUserid = (userid)=> {this._userid = userid;}
	var setSsn = (ssn)=> {this._ssn = ssn;}
	var setPassword = (password)=> {this._password = password;}
	var setRoll = (roll)=> {this._roll = roll;}
	var setTeamid = (teamid)=> {this._teamid = teamid;}
	var setAge = x=>{
       var date = new Date().getFullYear();
       this._age = date - 1900 + 1 - x.substring(0,2);
       }
   var setGender = x=>{
       if(x.substring(7,8) === '1'){
           this._gender = 'man';
       }else{
           alert(x.substring(7,8));
           this._gender = 'woman';
	       }
	   }
	var getName = ()=> {return this._name;}
	var getUserid = ()=> {return this._userid;}
	var getSsn = ()=> {return this._ssn;}
	var getPassword = ()=> {return this._password;}
	var getGender = ()=> {return this._gender;}
	var getAge = ()=> {return this._age;}
	var getRoll = ()=> {return this._roll;}
	var getTeamid = ()=> {return this._teamid;}
	return{
		setName : setName,
		setUserid : setUserid,
		setSsn : setSsn,
		setPassword : setPassword,
		setGender : setGender,
		setAge : setAge,
		setRoll : setRoll,
		setTeamid : setTeamid,
		getName : getName,
		getUserid : getUserid,
		getSsn: getSsn,
		getPassword : getPassword,
		getGender : getGender,
		getAge : getAge,
		getRoll : getRoll,
		getTeamid : getTeamid,
		join : x =>{
			member.setAge(x);
			member.setGender(x);
		}
	}
})();