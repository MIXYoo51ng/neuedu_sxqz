package com.neuedu.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.service.EmpService;
import com.neuedu.service.impl.EmpServiceImpl;

@WebServlet(urlPatterns="/emplist.do",loadOnStartup=1)
public class EmplistViewServlet extends HttpServlet{

	private static final long serialVersionUID = 8097631318934041631L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpService empservice = new EmpServiceImpl();
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		req.setAttribute("emplist", empservice.selectEmpList());
		req.setAttribute("now", f.format(date));
		req.getRequestDispatcher("/WEB-INF/jsp/emplist.jsp").forward(req, resp);
	}
	
}
