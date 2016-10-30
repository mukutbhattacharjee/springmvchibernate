package com.example.mukut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mukut.entity.User;
import com.example.mukut.service.UserService;
import com.example.mukut.service.UserServiceImpl;

@Controller
public class RegisterController {
	
	@Autowired
	UserServiceImpl userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
//get the registration form
	@RequestMapping(value="/getRegisterForm",method=RequestMethod.GET)
	public String getRegistrationForm(){
		return "registrationForm";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String registerUser(@RequestParam("email") String email, 
			@RequestParam("password") String password){
		System.out.println("in controller");
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		userService.saveUser(user);
		return "regSuccess";
	}
	
	

}
