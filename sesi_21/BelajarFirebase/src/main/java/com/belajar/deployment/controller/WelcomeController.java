package com.belajar.deployment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // tag controller
@RequestMapping("/api")
public class WelcomeController {
	
	@RequestMapping("/hello")
	public String home() {
		return "index";
	}
	
	@GetMapping("/welcome")
	public String index() {
		return "Welcome...";
	}

}
