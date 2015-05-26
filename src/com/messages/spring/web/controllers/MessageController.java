package com.messages.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;
import com.messages.spring.web.dao.FormGroup;
import com.messages.spring.web.dao.Message;
import com.messages.spring.web.services.MessageService;
import com.messages.spring.web.services.UserService;

@Controller
public class MessageController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/showmsgs")
	public String showMessages(Model model){
		List<Message> messages = messageService.getMessages();	
		model.addAttribute("messages", Lists.reverse(messages));
		return "messages";
	}
	
	@RequestMapping("/createmsg")
	public String createMessage(Model model){
		model.addAttribute("message", new Message());
		return "createmsgform";
	}
	
	@RequestMapping(value="/docreatemsg", method=RequestMethod.POST)
	public String doCreateMessage(Model model, @Validated(value=FormGroup.class) Message message, BindingResult result, Principal principal){
		
		if(result.hasErrors()){
			System.out.println("Form has errors...");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error: errors){
				System.out.println(error);
			}
			return "createmsgform";
		}
//		SecurityContextHolder.getContext().getAuthentication().getName()
		message.setUsername(principal.getName());
		
		try {
			messageService.saveOrUpdate(message);
		} catch (Exception e) {
			System.out.println("message creation failed!");
			e.printStackTrace();
		}
		return "home";
	}
	
}
