<%@page import="com.neuedu.entity.User"%>
<%@page import="com.neuedu.entity.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<%out.print(request.getAttribute("now"));%>
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
							ID
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
					<%
						List<Emp> emplist = (List<Emp>)request.getAttribute("emplist");
					%>
					<%
						for(int i = 0; i < emplist.size(); i++){
							if(i % 2 == 0){
					%>
					<tr class="row1">
						<td>
							<%out.print(emplist.get(i).getId()); %>
						</td>
						<td>
							<%out.print(emplist.get(i).getName()); %>
						</td>
						<td>
							<%out.print(emplist.get(i).getSalary()); %>
						</td>
						<td>
							<%out.print(emplist.get(i).getJob()); %>
						</td>
						<td>
							<a href="emplist.html">delete emp</a>&nbsp;<a href="updateEmp.html">update emp</a>
						</td>
					</tr>
					<%
							}else{
					%>
					<tr class="row2">
						<td>
							<%out.print(emplist.get(i).getId()); %>
						</td>
						<td>
							<%out.print(emplist.get(i).getName()); %>
						</td>
						<td>
							<%out.print(emplist.get(i).getSalary()); %>
						</td>
						<td>
							<%out.print(emplist.get(i).getJob()); %>
						</td>
						<td>
							<a href="emplist.html">delete emp</a>&nbsp;<a href="updateEmp.html">update emp</a>
						</td>
					</tr>
					<%
							}
						}
					%>
				</table>
				<p>
					<input type="button" class="button" value="Add Employee" onclick="location='addEmp.html'"/>
				</p>
			</div>
		</div>
		<%
			User user = (User)session.getAttribute("user");
		%>
		<div id="footer">
			<div id="footer_bg">
			ABC@126.com
				<span style="float:right;">
					<%
						if(user != null){
							out.print("欢迎:"+user.getUsername());
					%>
					<a href="exit.do" style="text-decoration:none;color:#FFFFFF;">退出</a>
					<%
						}else{
					%>
					<a href="loginview.do" style="text-decoration:none;color:#FFFFFF;">亲,请登录</a>
					<a href="registerview.do" style="text-decoration:none;color:#FFFFFF;">注册新用户</a>
					<%
						}
					%>
				</span>
			</div>
		</div>
	</div>
</body>
</html>