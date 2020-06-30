package com.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Contact;
import com.model.User;

import com.service.UserService;

@Controller
public class UserControler {

	
	@Autowired
	UserService userService;
	
//	@GetMapping("/")
//	public String getIndex(Model model) {
//		User user = userService.getUserById("1");
//		model.addAttribute(user);
//		return "index";
//	}
	
	@GetMapping("/")
	public String getContact(Model model) {
		Contact con = userService.getContact("1");
		model.addAttribute("contact",con);
		return "contact";
	}

	@GetMapping("/login")
	public String logIn(Model model) {
		
		return "login";
	}
}
