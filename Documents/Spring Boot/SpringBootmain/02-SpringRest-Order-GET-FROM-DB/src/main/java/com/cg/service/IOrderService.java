package com.cg.service;

import java.util.List;

import com.cg.model.Order;

public interface IOrderService {
	
	List<Order> findAllProducts();
	 
	List<Order> addProducts();
}
