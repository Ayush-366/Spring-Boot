package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.OrderDTO;
import com.cg.entity.Order;
import com.cg.service.IOrderService;

@RequestMapping("/api")
@RestController
public class OrderController {
	@Autowired
	IOrderService orderService;
	
	@GetMapping("/getorderbyid/{id}")
	public OrderDTO getOrderById(@PathVariable int id) {
		Order order = orderService.findAllByorderId(id);
		return OrderDTO.fromEntity(order); // Convert to DTO
	   }
	 
}

