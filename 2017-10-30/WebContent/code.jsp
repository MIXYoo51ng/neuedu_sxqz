<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	function test(){
		var code = document.getElementById("code").value;
		$.ajax({
			type:"get",
			url:"checkcode.do?code="+code,
			success:function(text){
				if (text == "true") {
					document.getElementById("checkcode").innerHTML = "√";
					document.getElementById("checkcode").style.color = "green";
				}else{
					document.getElementById("checkcode").innerHTML = "×";
					document.getElementById("checkcode").style.color = "red";
				}
			}
		});
	}
	function change(){
		document.getElementById("cimg").src = "code.do?"+Math.random();
	}
</script>
</head>
<body>
	<form action="">
		验证码:<img src="code.do" id="cimg"><input type="text" id="code" onblur="test();">
		<a href="javascript:;" onclick="change();">切换验证码</a>
		<span id="checkcode"></span>
	</form>
</body>
</html>