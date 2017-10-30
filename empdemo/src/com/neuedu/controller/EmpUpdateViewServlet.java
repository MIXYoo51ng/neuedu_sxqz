package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.service.EmpService;
import com.neuedu.service.impl.EmpServiceImpl;

@WebServlet(urlPatterns="/updateempview.do")
public class EmpUpdateViewServlet extends HttpServlet{

	private static final long serialVersionUID = -1567060367217939912L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		EmpService empservice = new EmpServiceImpl();
		req.setAttribute("emp", empservice.selectEmpById(id));
		req.getRequestDispatcher("WEB-INF/jsp/updateEmp.jsp").forward(req, resp);
	}
	
}
