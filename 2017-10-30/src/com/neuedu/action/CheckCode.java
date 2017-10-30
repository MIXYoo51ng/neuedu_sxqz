package com.neuedu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/checkcode.do")
public class CheckCode extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//从session中取出放入的验证码 
		String code = (String)req.getSession().getAttribute("code");
		//获得ajax请求传过来的验证码,前台输入的验证码
		String html_code = req.getParameter("code");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (code.equals(html_code)) {
			out.print(true);
		}else{
			out.print(false);
		}
		out.close();
	}
	
}
