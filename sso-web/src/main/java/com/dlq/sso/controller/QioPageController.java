package com.dlq.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QioPageController {
	
	
	@RequestMapping("/page/register")
	public String showRegister(){
		return "register";
	}
	
//	@RequestMapping("/page/login")
//	public String showLogin(){
//		return "login";
//	}
	
	@RequestMapping("/page/login")
	public String showqishoplogin(String redirectUrl,Model model){
		model.addAttribute("redirect", redirectUrl);
		return "login";
	}
}
