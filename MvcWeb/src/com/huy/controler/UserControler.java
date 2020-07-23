package com.huy.controler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huy.component.CustomBCryptPasswordEncoder;
import com.huy.model.Contact;
import com.huy.model.Product;
import com.huy.model.UserPrincipal;
import com.huy.model.Users;
import com.huy.service.UserService;

@Controller
public class UserControler {
	@Autowired
	CustomBCryptPasswordEncoder PasswordEncoder;
	
	@Autowired
	UserService userService;
	
//	@GetMapping("/")
//	public String getIndex(Model model) {
//		User user = userService.getUserById("1");
//		model.addAttribute(user);
//		return "index";
//	}
	
	@GetMapping("/contact")
	public String getContact(Model model) {
		Contact con = userService.getContact("1");
		model.addAttribute("contact",con);
		return "contact";
	}

	@GetMapping("/login")
	public String logIn(Model model) {
		
		return "login";
	}
	@GetMapping("/register")
	public String getrRgisterPage(Model model) {
		return "register";
	}
	@RequestMapping(value= "/doRegister", method=RequestMethod.POST)
	public String registerHandal(Model model,
			@RequestParam("username") String uName,
			@RequestParam("fname") String fName,
			@RequestParam("psw") String pass,
			@RequestParam("email") String email){
		Users user = new Users();
		user.setFullname(fName);
		user.setUsername(uName);
		user.setPassword(PasswordEncoder.encode(pass));
		user.setEmail(email);
		userService.insertUser(user);
		return "login";
	}
	@GetMapping("/information")
	public String getInformation(
								Model model,
								Authentication authentication) {
		UserPrincipal userprin = (UserPrincipal)authentication.getPrincipal();
		model.addAttribute("user",userprin);
		model.addAttribute("logedUsername",authentication.getName());
//		if(product != null)
//			model.addAttribute("proList",product);
		return "information";
	}
}
