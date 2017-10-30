<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>regist</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style2.css" />
	<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
	<script type="text/javascript">
		//定义一些标记点	
		var isusername = false;
		var ispassword = false;
		var ispassword2 = false;
		var isheadimage = false;
		var ischeckcode = false;
		
		//验证用户名
		function checkUsername(){
			var username = $("#username").val();
			var reg = new RegExp(/^[a-zA-Z]{1}[0-9a-zA-Z]{5,11}$/);
			var boo = reg.test(username);
			if (boo) {
				$.ajax({
					type:"get",
					url:"checkusername.do?username="+username,
					success:function(text){
						if (text == "false") {
							$("#checkUsername").html("√");
							$("#checkUsername").css("color","green");
							isusername = true;
						}else{
							$("#checkUsername").html("用户名已存在");
							$("#checkUsername").css("color","red");
							isusername = false;
						}
					}
				});
			}else{
				$("#checkUsername").html("首字母必须是英文,长度为6~12位");
				$("#checkUsername").css("color","red");
				isusername = false;
			}
			issub();
		}
		//验证密码
		function checkPassword(){
			var password = $("#password").val();
			var reg = new RegExp(/^[a-zA-Z0-9]{6,12}$/);
			var boo = reg.test(password);
			if (boo) {
				$("#checkPassword").html("√");
				$("#checkPassword").css("color","green");
				ispassword = true;
			}else{
				$("#checkPassword").html("密码长度为6~12位");
				$("#checkPassword").css("color","red");
				ispassword = false;
			}
			issub();
		}
		//验证确认密码
		function checkPassword2(){
			var password2 = $("#password2").val();
			var password = $("#password").val();
			var reg = new RegExp(/^[a-zA-Z0-9]{6,12}$/);
			var boo = reg.test(password2);
			if (boo) {
				if (password == password2) {
					$("#checkPassword2").html("√");
					$("#checkPassword2").css("color","green");
					ispassword2 = true;
				}else{
					$("#checkPassword2").html("两次密码不一致");
					$("#checkPassword2").css("color","red");
					ispassword2 = false;
				}
			}else{
				$("#checkPassword2").html("密码长度为6~12位");
				$("#checkPassword2").css("color","red");
				ispassword2 = false;
			}
			issub();
		}
		
		//验证头像文件格式
		function checkHeadimage(){
			var headimagepath = $("#headimage").val();
			var suffix = headimagepath.substr(headimagepath.lastIndexOf("."));
			if (suffix == ".jpg" || suffix == ".jpeg" || suffix == ".png") {
				$("#checkHeadimage").html("√");
				$("#checkHeadimage").css("color","green");
				isheadimage = true;
			}else{
				$("#checkHeadimage").html("只支持jpg、jpeg、png格式");
				$("#checkHeadimage").css("color","red");
				isheadimage = false;
			}
			issub();
		}
		
		//验证码
		function checkcodenum(){
			var num = $("#number").val();
			$.ajax({
				type:"get",
				url:"checkcodenum.do?num="+num,
				success:function(text){
					if (text == "true") {
						$("#checkcodenum").html("√");
						$("#checkcodenum").css("color","green");
						ischeckcode = true;
						issub();
					}else{
						$("#checkcodenum").html("验证码错误");
						$("#checkcodenum").css("color","red");
						ischeckcode = false;
						issub();
					}
				}
			});
		}
		
		function issub(){
			if (isusername && ispassword && ispassword2 && isheadimage && ischeckcode) {
				$("#sub").removeAttr("disabled");
			}else{
				
			}
		}
	</script>
</head>
<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								${now}
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="register.do" method="post" enctype="multipart/form-data">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" id="username" onblur="checkUsername();"/>
									<span id="checkUsername"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" id="password" onblur="checkPassword();"/>
									<span id="checkPassword"></span>
								</td>
							</tr><tr>
								<td valign="middle" align="right">
									确认密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password2" id="password2" onblur="checkPassword2();"/>
									<span id="checkPassword2"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="男" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="女"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									头像:
								</td>
								<td valign="middle" align="left">
									<input type="file" name="headimage" onchange="checkHeadimage();" id="headimage"> 
									<span id="checkHeadimage"></span>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="checkcode.do" />
									<a href="javascript:;" onclick="document.getElementById('num').src = 'image?'+(new Date()).getTime()">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" id="number" onblur="checkcodenum();"/>
									<span id="checkcodenum"></span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" disabled="disabled" id="sub"/>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>