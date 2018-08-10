"use strict";
var router = (()=>{
	return {move:x=>{  
		location.href = 
			x.context + '/' 
			+ x.domain
			+ '.do?action='+x.action
			+ '&page='+x.page
		}
	};  
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

var common = (()=> {
	return {
		main : x=>{
			document.getElementById('moveLoginForm').addEventListener('click',
					function() {
						router.move({context : x ,
									domain : 'member',
									action : 'move',
									page : 'login'});
					}),
			document.getElementById('moveJoinForm').addEventListener('click',
					function() {
						router.move({context : x,
									domain : 'member',
									action : 'move', 
									page : 'add'});
					}),	
			document.getElementById('moveHome').addEventListener('click',
					function() {
					router.move({context : x,
								domain : 'common'
								});
					}),
			document.getElementById('moveMypage').addEventListener('click',
					function() {
					router.move({context : x ,
								domain : 'member',
								action : 'move',
								page : 'retreive'});
					}),
			document.getElementById('moveToAdminMain').addEventListener('click',
					function() {
					router.move({context : x,
								domain : 'admin',
								action : 'search',
								page : 'main'})
								
								/*var isAdmin = confirm('Are you an administrator?'); 
								if(isAdmin){
									var password = prompt('Enter your admin Access code!!!');
									if(password == 1){
										router.move({
											context : x,
											domain : 'admin',
											action : 'search',
											page : 'main'});
										} else{
											alert('Wrong Access code!!!');
										}
									} else{
										alert('Only administrator can access this function!!!');
									}*/
			});
			}
	};})();

var admin = (()=>{
	return{
		main : x=>{
			for(var i of document.querySelectorAll('.username')){
                service.addClass(i, 'cursor fontColorBlue');
                i.addEventListener('click', ()=>{
                    location.href=x+'/admin.do?action=retrieve&page=retrieve&searchWord='
                    +this.getAttribute('id');
                });
            }
			
			for(var i of document.querySelectorAll('.pageNumber')){
				service.addClass(i,	'cursor fontColorBlue');	
			i.addEventListener('click',function(){
				location.href=x+'/admin.do?action=search&page=main&pageNumber='
				+this.getAttribute('id');
				});
			}			
			
			document.getElementById('searchBtn')
			.addEventListener('click',()=> {
				location.href=(document.getElementById('searchOption').value==='userid') ?
					x+'/member.do?action=retrieve&page=retrieve&searchWord='+document.getElementById('searchWord').value
					:
					x+'/admin.do?action=search&page=main&searchOption='+document.getElementById('searchOption').value+'&searchWord='+document.getElementById('searchWord').value		
					;
			});
			
            service.addClass(
                    document.getElementById('searchWord'),
                    'width100px floatRight');
            service.addClass(
                    document.getElementById('searchOption'),
                    'floatRight ');  
			service.addClass(
                    document.getElementById('searchBox'),
                    'width80pt center');
            service.addClass(
                    document.getElementById('contentBoxTab'),
                    'width90pt center marginTop30px');    
            service.addClass(
                    document.getElementById('contentBoxMeta'),
                    'bgColorBlue ');	
			service.addClass(
					document.getElementById('searchBtn'),
					'floatRight '); 
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
			main : x=> {
				document.getElementById('myPageMoveToUpdate').addEventListener('click',
						function() {
					router.move({context : x,
						domain : 'member',
						action : 'move', 
						page : 'modify'
					});
				}),			
				document.getElementById('myPageMoveToDelete').addEventListener('click',
						function() {
					router.move({context : x,
						domain : 'member',
						action : 'move', 
						page : 'remove'
					});
				});
			},
			
			join : x =>{
				member.setAge(x);
				member.setGender(x);
			}
	}
})();