package com.belajar.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // tag sebagai rest controller
@RequestMapping(value = "/belajar-api/v1") // tag untuk membuat endpoint
public class BelajarApiController {
	
	@GetMapping(value = "/get") // tag method yang digunakan
	public String belajarApi() {
		return "Mari Belajar API Java Spring Boot";
	}

}
