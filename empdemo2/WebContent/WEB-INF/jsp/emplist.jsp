<%@page import="com.neuedu.entity.User"%>
<%@page import="com.neuedu.entity.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>emplist</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style2.css" />
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
					Welcome!
				</h1>
				<table class="table">
					<tr class="table_header">
						<td>
							Num
						</td>
						<td>
							Name
						</td>
						<td>
							Salary
						</td>
						<td>
							Job
						</td>
						<td>
							Operation
						</td>
					</tr>
					<c:forEach items="${emplist}" var="emp" varStatus="i">
						<c:if test="${i.index % 2 == 0}" var="index">
							<tr class="row1">
								<td>
									${i.index+1}
								</td>
								<td>
									${emp.name}
								</td>
								<td>
									${emp.salary}
								</td>
								<td>
									${emp.job}
								</td>
								<td>
									<a href="deleteemp.do?id=${emp.id}">delete emp</a>&nbsp;<a href="updateempview.do?id=${emp.id}">update emp</a>
								</td>
							</tr>
						</c:if>
						<c:if test="${!index}">
							<tr class="row2">
								<td>
									${i.index+1}
								</td>
								<td>
									${emp.name}
								</td>
								<td>
									${emp.salary}
								</td>
								<td>
									${emp.job}
								</td>
								<td>
									<a href="deleteemp.do?id=${emp.id}">delete emp</a>&nbsp;<a href="updateempview.do?id=${emp.id}">update emp</a>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				<p>
					<input type="button" class="button" value="Add Employee" onclick="location='addEmp.html'"/>
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">
			ABC@126.com
				<span style="float:right;">
					<c:if test="${sessionScope.user != null}">
						欢迎,${sessionScope.user.username}
						<img src="${sessionScope.user.headimgpath}" style="width:16px;height:16px;border-radius:50%;">
						<a href="exit.do" style="text-decoration:none;color:#FFFFFF;">退出</a>
					</c:if>
				</span>
			</div>
		</div>
	</div>
</body>
</html>