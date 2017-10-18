package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;
/**
 * 用于登录
 * @author neuedu
 *
 */
@WebServlet(urlPatterns="/login.do",loadOnStartup=1)
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 8606608159237396153L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService userservice = new UserServiceImpl();
		User user = userservice.selectUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			//重定向到emplist.do组件中
			resp.sendRedirect("emplist.do");
		}else{
			//登录失败重定向到登录页面
			resp.sendRedirect("loginview.do");
		}
	}
	
}
