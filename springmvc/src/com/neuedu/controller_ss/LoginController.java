package com.neuedu.controller_ss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class LoginController {

	@RequestMapping("/loginview.do")
	public ModelAndView loginview(){
		return new ModelAndView("login");
	}
	
	@RequestMapping("/logina.do")
	public ModelAndView login(String username,String password){
		ModelAndView model = new ModelAndView("islogin");
		if ("admin".equals(username) && "1234".equals(password)) {
			model.addObject("islogin", "ÊÇ");
		}else{
			model.addObject("islogin", "·ñ");
		}
//		model.setViewName("islogin");
		return model;
	}
	
}
