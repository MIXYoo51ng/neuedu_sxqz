<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.neuedu.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		request.setAttribute("test", "<div>asdf</div>");
		request.setAttribute("now", new Date());
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
	
	
	<c:choose>
	    <c:when test="${param.num>0}">我大于0
	    </c:when>
	    <c:when test="${param.num<0}">我小于0
	    </c:when>
	    <c:when test="${param.num==0}">我等于0
	    </c:when>
	    <c:otherwise>我是特例</c:otherwise>
	   </c:choose>
	   
	   
	   <c:out value="${test}" default="1" escapeXml="false"></c:out>
	   
	   
	  <%--  <c:set var="salary" scope="session" value="${5600*2}"></c:set> --%>
	  
	  
	  <a href="<c:url value='test.do'></c:url>">测试sessionid</a>
	  
	  <div></div>
	  <f:formatDate value="${now}" dateStyle="SHORT"/>
	  
</body>
</html>