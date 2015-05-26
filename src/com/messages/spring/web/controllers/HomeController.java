package com.messages.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String showHome(){
		return "home";
	}
	
	@RequestMapping("/denied")
	public String showDenied(){
		return "denied";
	}
}
