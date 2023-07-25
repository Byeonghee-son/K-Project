package com.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.airport.domain.User;
import com.airport.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login/login")
	public void login() {
		
	}
	
	@GetMapping("/login/signup")
	public void signup() {		
		
	}
	
	@PostMapping("/login")
	public String login(User user, Model model) {
		User findUser = userService.getUser(user);
		if(findUser != null && findUser.getPw().equals(user.getPw())) {
			model.addAttribute("user", findUser);
		return "forward:getUserList";
		} else
			return "/error/loginError.html";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}
	


}
