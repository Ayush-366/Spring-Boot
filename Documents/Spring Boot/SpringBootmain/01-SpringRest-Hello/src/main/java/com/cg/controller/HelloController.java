package com.cg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String sayHello() 
	{
		return "Hello Applicaion";
	}

}
