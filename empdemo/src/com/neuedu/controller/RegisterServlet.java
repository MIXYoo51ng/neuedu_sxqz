package com.neuedu.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;
import com.neuedu.util.ImageUpUtil;

@WebServlet(urlPatterns="/register.do")
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = -6551637956114007578L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Map<String, String> param = ImageUpUtil.imageup(req, resp);
		User user = new User(null,param.get("username"),param.get("password"),param.get("name"),
				param.get("sex"),param.get("headimagepath"));
		//调用userservice将user插入到数据库
		UserService userservice = new UserServiceImpl();
		userservice.insertUser(user);
		req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
	}
	
}
