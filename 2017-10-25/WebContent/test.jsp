<%@ page import="java.util.Date"%>
<%@ page import="javax.swing.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="session.jsp"></jsp:forward>
	<%
		String path = "index.jsp";
		request.setAttribute("path", path);
	%>
	<%@ include file="index.jsp" %>
	<jsp:include page="${path }"></jsp:include>
	<a>测试</a>
	<%=config.getInitParameter("testparam") %>
	
	<!-- <a>sdfsdf</a> -->
	<%-- <a href="<%request.getAttribute("username");%>"></a> --%>
	
</body>
</html>