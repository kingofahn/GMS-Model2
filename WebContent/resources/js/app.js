"use strict";
var router = (()=>{
	return {move:x=>{  
		location.href = 
			x.context + '/' 
			+ x.domain
			+ '.do?action='+x.action
			+ '&page='+x.page
		}
	};  /* 이것이 클로져임, 키값:value 이 것이 JSON임 */
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
		},
		addClass : (dom,cName)=>{
            var arr = cName.split(" ");
            if(arr.indexOf(cName) == -1){
                dom.className += " " + cName;
		    }
		}
	}
})();

var admin = (()=>{
	return{
		check : x=>{
			var isAdmin = confirm('Are you an administrator?'); // 윈도우의 객체 BOM의
																// METHOD이다.
			if(isAdmin){
				var password = prompt('Enter your admin Access code!!!');
				if(password == 1){
					router.move({
						context : x,
						domain : 'admin',
						action : 'list',
						page : 'main'});
					} else{
						alert('Wrong Access code!!!');
					}
				} else{
					alert('Only administrator can access this function!!!');
				}
		},
		main : x=>{
			for(var i of document.querySelectorAll('.username')){
                service.addClass(i, 'cursor fontColorBlue');
                i.addEventListener('click', function(){
                    location.href=x+'/admin.do?action=retrieve&'+'page=memberDetail&userid='+this.getAttribute('id');
                    //여기서의 this는 x[i]를 호출하는 녀석 
                });
            }
			
			document.getElementById('searchBtn')
				.addEventListener('click',function() {
					location.href=(document.getElementById('searchOption').value==='userid') ?
						x+'/admin.do?action=RETRIEVE&page=memberDetail&userid='+document.getElementById('searchWord').value
						:
						x+'/admin.do?action=SEARCH&page=main&searchOption='+document.getElementById('searchOption').value+'&searchWord='+document.getElementById('searchWord').value		
						;
			});
            service.addClass(
                    document.getElementById('searchWord'),
                    'width100px floatRight');
			service.addClass(
                    document.getElementById('searchBox'),
                    'width80pt center');
			service.addClass(
					document.getElementById('searchBtn'),
					'floatRight '); 
            service.addClass(
                    document.getElementById('searchOption'),
                    'floatRight ');    
            service.addClass(
                    document.getElementById('contentBoxTab'),
                    'width90pt center marginTop30px');    
            service.addClass(
                    document.getElementById('contentBoxMeta'),
                    'bgColorBlue ');	
			
		}
	};
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