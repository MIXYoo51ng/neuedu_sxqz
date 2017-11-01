<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileup.do" method="post" enctype="multipart/form-data">
		文件:<input type="file" name="file"><br>
		username:<input type="text" name="username"><br>
		<input type="submit">
	</form>
</body>
</html>