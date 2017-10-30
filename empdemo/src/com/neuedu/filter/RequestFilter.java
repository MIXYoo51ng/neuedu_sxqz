package com.neuedu.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.User;

@WebFilter(urlPatterns="*.do")
public class RequestFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		ServletContext application = request.getServletContext();
		application.setAttribute("now",f.format(date));
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//获得请求uri,判断是否以指定字符串结尾,对不需要登录的请求进行放行
		String uri = req.getRequestURI();
		if (uri.endsWith("loginview.do") || uri.endsWith("login.do") ||
				uri.endsWith("registerview.do") || uri.endsWith("register.do") ||
				uri.endsWith("checkusername.do") || uri.endsWith("checkcode.do") || 
				uri.endsWith("checkcodenum.do")) {
			chain.doFilter(request, response);
		}else{
			HttpSession session = req.getSession();
			User user = (User)session.getAttribute("user");
			if (user == null) {
				resp.sendRedirect("loginview.do");
			}else{
				chain.doFilter(request, response);
			}
		}
	}

}
