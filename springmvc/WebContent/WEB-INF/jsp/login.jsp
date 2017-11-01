<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style2.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	var isusername = false;
	var ispassword = false;
	function checkForm(checkinput,checkout,message){
		var forminput = $("#" + checkinput).val();
		var check = $("#" + checkout);
		if (forminput == "") {
			check.html(message);
			check.css("color","red");
			if (checkinput == "username") {
				isusername = false;
			}else if(checkinput == "password"){
				ispassword = false;
			}
		}else{
			check.html("√");
			check.css("color","green");
			if (checkinput == "username") {
				isusername = true;
			}else if(checkinput == "password"){
				ispassword = true;
			}
		}
		if (isusername && ispassword) {
			$("#sub").removeAttr("disabled");
		}else{
			$("#sub").attr("disabled","disabled");
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
					login
				</h1>
				<form action="logina.do" method="post">
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr>
							<td valign="middle" align="right">
								username:
							</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="username" onblur="checkForm('username','checkusername','用户名不能为空');" id="username"/>
								<span id="checkusername"></span>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">
								password:
							</td>
							<td valign="middle" align="left">
								<input type="password" class="inputgri" name="password" id="password" onblur="checkForm('password','checkpassword','密码不能为空');"/>
								<span id="checkpassword"></span>
							</td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="Submit &raquo;" id="sub"/>
					</p>
				</form>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">
				ABC@126.com
				<a style="color:#FFFFFF;float:right;text-decoration:none;" href="registerview.do">注册</a>
		</div>
		</div>
	</div>
</body>
</html>