package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Order;
import com.cg.service.IOrderService;



@RequestMapping("/api")
@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderservice;
	
	@GetMapping("/orders")
	//@GetMapping(path = "/products", produces = {MediaType.APPLICATION_XML_VALUE})
	public List<Order> getOrder()
	{
		return orderservice.findAllProducts();
	}
 	
	@GetMapping("/hello")
	public String sayHello() 
	{
		return "Hello Applicaion";
	}

}
