package com.assignment.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // tag controller
public class IndexController {
	
	@GetMapping("/hello")
	public String index() {
		return "index";
	}

}
