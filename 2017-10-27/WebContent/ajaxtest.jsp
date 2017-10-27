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
	//发送ajax
	function sendgetajax(){
		var xhr = getXmlHttpRequest();
		//打开,绝对不是发送
		xhr.open("get","testajax.do?username=中文",true);
		//注册一个监听器,当状态改变时会被调用
		xhr.onreadystatechange=function(event){
			if (xhr.readyState == 4) {
				alert("ajax请求完成");
				//通过核心对象获得servlet中响应的文本(不是xml格式的)
				var text = xhr.responseText;
				alert(text);
			}
		};
		//发生送请求
		xhr.send();
	}
	
	function sendpostajax(){
		var xhr = getXmlHttpRequest();
		//打开,绝对不是发送
		xhr.open("post","testajax.do",true);
		//注册一个监听器,当状态改变时会被调用
		xhr.onreadystatechange=function(event){
			if (xhr.readyState == 4) {
				alert("ajax请求完成");
				//通过核心对象获得servlet中响应的文本(不是xml格式的)
				var text = xhr.responseText;
				alert(text);
			}
		};
		//必须添加一个消息头 content-type,post请求必须要有的
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//发生送请求
		xhr.send("username=中文&password=1234");
	}
	
</script>
</head>
<body>
	<button type="button" onclick="sendgetajax();">发送getajax</button>
	<button type="button" onclick="sendpostajax();">发送postajax</button>
</body>
</html>