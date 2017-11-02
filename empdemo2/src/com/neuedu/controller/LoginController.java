package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;

@Controller
public class LoginController {

	@RequestMapping("/loginview.do")
	public String loginview(){
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(String username,String password){
		UserService userservice = new UserServiceImpl();
		User user = userservice.selectUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return "redirect:emplist.do";
		}else{
			return "redirect:loginview.do";
		}
	}
	
}
