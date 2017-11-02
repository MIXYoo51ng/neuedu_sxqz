package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.service.EmpService;
import com.neuedu.service.impl.EmpServiceImpl;

@Controller
public class EmpController {

	@RequestMapping("/emplist.do")
	public ModelAndView emplist(){
		EmpService empservice = new EmpServiceImpl();
		ModelAndView model = new ModelAndView("emplist");
		model.addObject("emplist", empservice.selectAllEmp());
		return model;
	}
	
	@RequestMapping("/deleteemp.do")
	public String deleteemp(Integer id){
		EmpService empservice = new EmpServiceImpl();
		empservice.deleteEmpById(id);
		return "redirect:emplist.do";
	}
	
}
