package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/test.do")
	public ModelAndView test(){
		ModelAndView model = new ModelAndView("test");
		model.addObject("testparam", "这是测试值");
		return model;
	}
	
	@RequestMapping("/test1.do")
	public ModelAndView test1(){
		ModelAndView model = new ModelAndView("test");
		model.addObject("testparam", "这是测试值");
		return model;
	}
	
}
