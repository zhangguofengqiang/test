					function getByteLength(str){
						return str.replace(/[^\x00-\xff]/g,'aa').length;
					}
					$(function(){
						
						var checkEmail=false;
						$('#txtEmail').blur(function(){
							$('#email.info').html('');
							var v=$.trim($('#txtEmail').val());
							if(v==''){
								$('#email\\.info').html('<img src="../images/wrong.gif">邮箱没有填写');
								 checkEmail=false;
								 return;
							}
							var reg=/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
							if(!reg.test(v)){
								$('#email\\.info').html('<img src="../images/wrong.gif">邮箱格式不正确');
								 checkEmail=false;
								 return;
							}
							$.ajax({
							url:"/dang_ssm/user/"+v+".do",
							dataType:"text",
							type:"post",
							success:function(data){
								if(data=="success"){
									$('#email\\.info').html('<img src="../images/right.gif">');
									checkEmail=true;
								}else{
									$('#email\\.info').html('<img src="../images/wrong.gif">邮箱已被注册');
									checkEmail=false;
								}
							}
							});
						});
						
						var checkNickName=false;
						$('#txtName').blur(function(){
							$('#name\\.info').html('');
							var v=$.trim($('#txtName').val());
							if(v==''){
								$('#name\\.info').html('<img src="../images/wrong.gif">昵称没有填写');
								 checkNickName=false;
								 return;
							}
							var reg=/[a-z0-9\u4e00-\u9fa5]+/;
							if(!reg.test(v)){
								$('#name\\.info').html('<img src="../images/wrong.gif">昵称格式错误');
								 checkNickName=false;
								 return;
							}
							if(getByteLength(v)<4 || getByteLength(v)>20){
								$('#name\\.info').html('<img src="../images/wrong.gif">昵称长度错误');
								 checkNickName=false;
								 return;
							}
							checkNickName=true;
							$.ajax({
								url:"/dang_ssm/user/checkName.do",
								data:"name="+v,
								dataType:"text",
								type:"post",
								success:function(data){
									if(data=="success"){
										$('#name\\.info').html('<img src="../images/right.gif">');
										checkEmail=true;
									}else{
										$('#name\\.info').html('<img src="../images/wrong.gif">昵称已经被使用');
										checkEmail=false;
									}
								}
								});
						});
						
						var checkPassword=false;
						var pwd1;
						$('#txtPassword').blur(function(){
							$('#password\\.info').html('');
							pwd1=$.trim($('#txtPassword').val());
							if(pwd1==''){
								$('#password\\.info').html('<img src="../images/wrong.gif">密码没有填写');
								 checkPassword=false;
								 return;
							}
							var reg=/[a-z0-9A-Z]{6,20}/;
							if(!reg.test(pwd1)){
								$('#password\\.info').html('<img src="../images/wrong.gif">密码格式错误');
								 checkPassword=false;
								 return;
							}
							$('#password\\.info').html('<img src="../images/right.gif">');
							checkPassword=true;
						});
						
						var checkPassword2=false;
						$('#txtRepeatPass').blur(function(){
							$('#password2\\.info').html('');
							var v=$.trim($('#txtRepeatPass').val());
							if(v==''){
								$('#password2\\.info').html('<img src="../images/wrong.gif">确认密码没有填写');
								 checkPassword2=false;
								 return;
							}
							if(v!=pwd1){
								$('#password2\\.info').html('<img src="../images/wrong.gif">两次输入的密码不一样');
								 checkPassword2=false;
								 return;
							}
							$('#password2\\.info').html('<img src="../images/right.gif">');
							checkPassword2=true;
						});
						
						
						var checkVCode=false;
						$('#txtVerifyCode').blur(function(){
							$('#number\\.info').html('');
							var v=$.trim($('#txtVerifyCode').val());
							if(v==''){
								$('#number\\.info').html('<img src="../images/wrong.gif">验证码没有填写');
								 checkVCode=false;
								 return;
							}else{
								$.ajax({
								url:"verifyCode.do",
								data:"code="+v,
								async:false,
								dataType:"text",
								type:"POST",
								success:function(data){
									if(data=="success"){
										checkVCode=true;
										$('#number\\.info').html('<img src="../images/right.gif">');
									}else{
										checkVCode=false;
										$('#number\\.info').html('<img src="../images/wrong.gif">验证码错误');
									}
								}});
							}
						});
						
						$('#f').submit(function(){
							if(!checkEmail){
								$('#txtEmail').blur();
							}
							if(!checkNickName){
								$('#txtName').blur();
							}
							if(!checkPassword){
								$('#txtPassword').blur();
							}
							if(!checkPassword2){
								$('#txtRepeatPass').blur();
							}
							if(!checkVCode){
								$('#txtVerifyCode').blur();
							}
							return checkEmail && checkNickName && checkPassword && checkPassword2 && checkVCode;
							//return false;
						});
					});