package com.assignment.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // tag sebagai rest controller
@RequestMapping(value = "/") // tag untuk membuat endpoint "/" sebagai landing page
public class IndexController {
	
	public String index() {
		return "index";
	}

}
