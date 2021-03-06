$(function(){
	$('#login').click(loginAction);
	$('#count').blur(checkName);
	$('#password').blur(checkPassword);
	$('#regist_button').click(registAction);
	$('#regist_username').blur(checkRegistName);
	$('#regist_password').blur(checkRegistPassword);
	$('final_password').blur(checkConfirm);
	
	$('#changePassword').click(change_password);
	$('#back').click(back_from_change_password);
	$('#logout').click(exit);//退出登录；
});
//检查验证密码知否正确
function checkConfirm(){
	console.log(1);
	var pwd = $('#final_password').val();
	var pwd1 = $('#regist_password').val();
	if(pwd && pwd==pwd1){
		$('#final_password').next().hide();
		return true;
	}
	$('#final_password').next().show().find('span').html('确认密码不一致');
	return false;
}

function checkRegistPassword(){
	var password = $('#regist_password').val();
	var rule = /^\w{4,10}$/;
	if(rule.test(password)){
		$('#regist_password').next().hide();
		return true;
	}
	$('#regist_password').next().show().find('span').html('4~10个字符');
	return false;
}
//注册功能
function registAction(){
	//检验界面参数
     var n = checkRegistName()+checkRegistPassword()+checkConfirm();
     if(n!=3){
    	 return;
     }
     //获取界面中的表单数据
     var name = $('#regist_username').val().trim();
     var password = $('#regist_password').val();
     var nick = $('#nickname').val();
     var confirm = $('#final_password').val();
     //发送Ajax请求.$.post请求就是$.ajax()，。$.post()封装了$.ajax()。其实就是一回事。result就是服务器返回的JsonResult(具体看服务器的返回参数)
     var url = "regist.do";
     var data = {name:name,
    		 nick:nick,
    		 password:password,
    		 confirm:confirm};
    /* $.post(url,data,function(result){
    	 console.log(result);
     });*/
     $.ajax({
    	 'url':url,
    	 'data':data,
    	 'type':'get',
    	 'dataType':'json',
    	 'success':function(result){
    		 console.log(result);
    		 if(result.state==0){
    			 //注册成功,并且把注册的名字直接放进name框内，给密码框绑定获得焦点事件
    			 $('#back').click();
    			 var name = result.data.name;
    			 $('#count').val(name);
    			 $('#password').focus();
    			 //清空表单
    			 $('#regist_username').val('');
    			 $('#regist_password').val('');
    			 $('#nickname').val('');
    			 $('#final_password').val('');
    		 }else if(result.state==4){
    			 $('#regist_username').next().show().find('span').html(result.message);
    		 }else if(result.state==3){
    			 $('#regist_password').next().shoe().find('span').html(result.message);
    		 }else{
    			 alert(result.message);
    		 }
    	 }
     });
}
function checkRegistName(){
	var name = $('#regist_username').val().trim();
	var rule = /^\w{4,10}$/;
	if(rule.test(name)){
		$('#regist_username').next().hide();
		console.log(1);
		return true;
	}
	console.log(2);
	$('#regist_username').next().show().find('span').html('4~10个字符');
	return false;
}
function loginAction(){
    //获取用户输入的用户名和密码
	var name = $('#count').val();
	var password = $('#password').val();
	
	var n = checkName()+checkPassword();
	if(n!=2){
		return;
	}
   
	//data对象的属性名要与服务器控制器中的参数名一致
	var data = {"name":name,"password":password};
	$.ajax({
		url:'login.do',
		data:data,
		type:'post',
		dataType:'json',
		success:function(result){
			console.log(result);
			if(result.state==0){
				//登录成功
				var user = result.data;
				console.log(user);
				//跳转到edit.html
				addCookie("UserId",user.id);
				window.location.href='edit.html';
			}else{
				var msg = result.message;
				if(result.state==2){
					//用户名出错
					$('#count').next().html(msg);
				}else if(result.state==3){
					//密码出错
					$('#password').next().html(msg);
				}else{
					alert(msg);
				}
			}
		},
		error:function(e){
			alert("通信失败");
		}
	});
}

function checkName(){
	var name = $('#count').val();
	//规定用户名从头到尾4到10个字母
	var rule = /^\w{4,10}$/;
	if(!rule.test(name)){
		//不符合规则
		$('#count').next().html('4-10个字符');
		return false;
	}
	$('#count').next().empty();
	return true;
}

function checkPassword(){
	var password = $('#password').val();
	//定义密码规则
	var rule = /^\w{4,10}$/;
	if(!rule.test(password)){
		//不符合规则
		$('#password').next().html('4-10个字符');
		return false;
	}
	$('#password').next().empty();
	return true;
}
//修改密码业务：用户输入原始密码，新密码和确认密码
function change_password(){
	var last_password = $('#last_password').val();
	var new_password = $('#new_password').val();
	var final_password = $('#final_password').val();
	var url = 'changePassword.do';
	var user_id = getCookie('UserId');
	console.log(last_password);
	
	console.log(new_password);
	console.log(final_password);
	console.log(user_id);
	var data = {
			user_id       : user_id,
			last_password : last_password,
			new_password  : new_password,
			final_password: final_password
	};
	$.post(url,data,function(result){
		console.log(result);
		//window.location.href='http://localhost:8089/note/edit.html';
		console.log(result.data['修改状态']);
		//第一个是修改状态，其值是0则修改成功，第二个是修改结果，返回“修改成功”
        //修改状态为1则修改失败，返回“修改失败”
        //修改状态为2则修改失败，原因是密码长度过短
        //修改状态为3则修改失败，原因是两次输入的密码不一致
        //修改状态为4则修改失败，原因是原始密码输入错误
		//修改成功
		if(result.data['修改状态']==0){
			back_from_change_password(); //'http://localhost:8089/note/edit.html';
			//alert("修改成功");
		}
		//修改失败
		if(result.data['修改状态']==1){
			alert("修改失败");
		}
		//原始密码错误
		if(result.data['修改状态']==4){
			$('#warning_2').hide();
			$('#warning_3').hide();
			$('#warning_1').show();
		}
		//新密码长度过短
		if(result.data['修改状态']==2){
			$('#warning_1').hide();
			$('#warning_3').hide();
			$('#warning_2').show();
		}
		//两次输入的密码长度不一致
		if(result.data['修改状态']==3){
			$('#warning_2').hide();
			$('#warning_1').hide();
			$('#warning_3').show();
		}
	});
}
function back_from_change_password(){
	console.log(111);
	window.history.back();//window.location.href='http://localhost:8089/note/edit.html';
}
function exit(){
	console.log(33);
}
