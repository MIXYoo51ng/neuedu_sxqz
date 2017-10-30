package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;

@WebServlet(urlPatterns="/checkusername.do")
public class CheckUsernameServlet extends HttpServlet{

	private static final long serialVersionUID = -6676492733805278831L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		UserService userservice = new UserServiceImpl();
		User user = userservice.selectUserByUsername(username);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (user != null) {
			out.print(true);
		}else{
			out.print(false);
		}
		out.close();
	}
	
}
