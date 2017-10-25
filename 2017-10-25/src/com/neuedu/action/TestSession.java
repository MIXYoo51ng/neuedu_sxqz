package com.neuedu.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/getsession.do")
public class TestSession extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取session对象,注意特点
		HttpSession session = req.getSession(true);
//		System.out.println(session.getId());
		session.setMaxInactiveInterval(60 * 30);
		session.setAttribute("user", new User());
		//主动删除session对象
		session.invalidate();
		resp.sendRedirect("session.jsp");
	}
	
}
