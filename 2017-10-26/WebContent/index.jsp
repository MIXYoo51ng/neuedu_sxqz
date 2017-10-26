<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		application.setAttribute("username", "admin");
		application.setAttribute("username", "admin1");
		application.removeAttribute("username");
	%>
</body>
</html>