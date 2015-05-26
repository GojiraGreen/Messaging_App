package com.messages.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.messages.spring.web.dao.FormGroup;
import com.messages.spring.web.dao.User;
import com.messages.spring.web.services.UserService;

@Controller
public class AccountController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/newacc")
	public String newAccount(Model model){
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping(value="/docreateacc", method=RequestMethod.POST)
	public String createAccount(Model model, @Validated(FormGroup.class) User user, BindingResult result){
		if(result.hasErrors()){
			System.out.println("Form has errors...");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error: errors){
				System.out.println(error);
			}
			return "newaccount";
		}
		
		if(userService.exists(user.getUsername())){
			result.rejectValue("username", "DuplicateKey.user.username", "Username already exists!");
			return "newaccount";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		try {
			userService.create(user);
		} catch (Exception e) {
			System.out.println("User creation failed!");
			e.printStackTrace();
		}
		
		return "login";
	}
}
