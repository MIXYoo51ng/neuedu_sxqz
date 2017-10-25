package com.neuedu.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.User;
import com.neuedu.util.CookieUtil;
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
		Cookie[] cookies = req.getCookies();
		Map<String, Cookie> cookiemap = CookieUtil.cookieToMap(cookies);
		Cookie cookie = cookiemap.get("username");
		if (cookie != null) {
			UserDao userdao = new UserDaoImpl();
			User user = userdao.selectUserByUsername(cookie.getValue());
			if (user != null) {
				resp.sendRedirect("login.do?username=" + user.getUsername() +"&password=" + user.getPassword());
			}else{
				req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
			}
		}else{
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
	}
	
}
