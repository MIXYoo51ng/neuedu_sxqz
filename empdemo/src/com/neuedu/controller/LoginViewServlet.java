package com.neuedu.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 通过这个控制器访问login页面
 * @author neuedu
 *
 */
@WebServlet(urlPatterns="/loginview.do",loadOnStartup=1)
public class LoginViewServlet extends HttpServlet{

	private static final long serialVersionUID = -2055290848186993777L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		req.setAttribute("now", f.format(date));
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
	}
	
}
