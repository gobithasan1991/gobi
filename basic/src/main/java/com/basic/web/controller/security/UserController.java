package com.basic.web.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.persitance.model.security.User;
import com.basic.service.security.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	} 
	@GetMapping("/save")
	public String save(@RequestBody User user) {
		return "success";
	}
}
