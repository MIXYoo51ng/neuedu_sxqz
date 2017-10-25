package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/exit.do",loadOnStartup=1)
public class ExitServlet extends HttpServlet{

	private static final long serialVersionUID = -2176999659019264581L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		Cookie cookie = new Cookie("username", "");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		resp.sendRedirect("loginview.do");
	}
	
}
