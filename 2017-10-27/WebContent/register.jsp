<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//判断浏览器对XMLHttpRequest的支持,否则创建ie的对象
	function getXmlHttpRequest(){
		var xhr = null;
		if((typeof XMLHttpRequest)!='undefined'){
			xhr = new XMLHttpRequest();
		}else {
			xhr = new ActiveXObject('Microsoft.XMLHttp');
		}
		return xhr;
	}
	
	function checkUsername(){
		var username = document.getElementById("username").value;
		//校验username是否存在
		var xhr = getXmlHttpRequest();
		//打开,绝对不是发送
		xhr.open("post","checkusername.do",true);
		//注册一个监听器,当状态改变时会被调用
		xhr.onreadystatechange=function(event){
			if (xhr.readyState == 4) {
				//通过核心对象获得servlet中响应的文本(不是xml格式的)
				var text = xhr.responseText;
				//trim取前后空格和换行符
				if (text.trim() == "true") {
					document.getElementById("checkusername").innerHTML = "用户名已存在";
					document.getElementById("checkusername").style.color = "red";
				}else{
					document.getElementById("checkusername").innerHTML = "√";
					document.getElementById("checkusername").style.color = "green";
				}
			}
		};
		//必须添加一个消息头 content-type,post请求必须要有的
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//发生送请求
		xhr.send("username="+username);
	}
	
</script>
</head>
<body>
	<form action="">
		用户名:<input type="text" onblur="checkUsername();" id="username">
		<span id="checkusername"></span>
	</form>
</body>
</html>