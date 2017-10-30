<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	function testjson(){
		$.ajax({
			"type":"get",
			"url":"testjson.do",
			success:function(text){
				//eval函数需要前后添加小括号
				//js中有一个内置对象叫做window,只要在js中直接调用方法或者属性,那么这些一定
				//是属于window对象的
				var jsontest = eval("("+text+")");
				//js中怎么操作对象
				//地址下拉列表,试着用ajax做地址下拉列表
			}
		});
	}
</script>
</head>
<body>
	<button type="button" onclick="testjson();">测试json</button>
</body>
</html>