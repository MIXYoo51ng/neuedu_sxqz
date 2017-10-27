<%@page import="java.util.ArrayList"%>
<%@page import="com.neuedu.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<User> userlist = new ArrayList<User>();
		userlist.add(new User("admin","1234"));
		userlist.add(new User("superadmin","123456"));
		userlist.add(new User("pzs","123456789"));
		request.setAttribute("userlist", userlist);
	%>
	<%-- <c:if test="${1 == 2}" var="testboo" scope="page">
		<div>满足条件</div>
	</c:if>
	<c:if test="${!(pageScope.testboo)}">
		<div>不满足条件</div>
	</c:if> --%>
	<c:forEach items="${userlist}" var="u" varStatus="i">
		<div>
			<span>${i.index + 1}</span>
			<span>${u.username}</span>
			<span>${u.password}</span>
		</div>
	</c:forEach>
	<%-- <c:forEach begin="0" end="10" step="2" var="x">
		<div>${x}</div>
	</c:forEach> --%>
</body>
</html>