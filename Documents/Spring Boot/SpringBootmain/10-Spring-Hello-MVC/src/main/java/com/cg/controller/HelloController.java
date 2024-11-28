package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("myHello")
public class HelloController {
	
	@GetMapping("hi")
	public String hello(Model model)
	{
		model.addAttribute("message", "Hello Kashif Bhai");
		return "Hello";
	}
	
}
