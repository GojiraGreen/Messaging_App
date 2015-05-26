package com.messages.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.messages.spring.web.dao.User;
import com.messages.spring.web.services.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/admin")
	public String showAdminPage(Model model){

		List<User> users = null;
		try {
			users = userService.getAllUsers();
		} catch (AccessDeniedException e) {
			System.out.println("Exception: " + e.getClass());
			return "denied";
		}
		model.addAttribute("users", users);
		return "admin";
	}
}
