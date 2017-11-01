package com.neuedu.controller_ss;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestMethod {

	@RequestMapping("/teststr.do")
	public String teststr(@RequestParam(defaultValue="admin",required=false,name="username") 
		String a,Map<String, Object> map){
		System.out.println(a);
		map.put("testparam", "ceshi");
		return "redirect:https://www.baidu.com";
	}
	
//	@RequestMapping("/testvoid")
//	public void testvoid(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
//		System.out.println(req.getParameter("username"));
//		req.setAttribute("testparam", "无返回值的测试参数");
//		req.getRequestDispatcher("WEB-INF/jsp/test.jsp").forward(req, resp);
//	}
	
	@RequestMapping("/test.do")
	public String test(String username){
		System.out.println(username);
		return null;
	}
	
	
}
