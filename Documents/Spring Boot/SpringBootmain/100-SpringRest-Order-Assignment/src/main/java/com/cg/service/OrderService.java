package com.cg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Order;
import com.cg.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	OrderRepository orderepository;
	
	
	@Override
	public List<Order> findAllOrders() {
		
		return orderepository.findAll();
		
		
//		ArrayList<Product> products = new ArrayList<Product>();
//		products.add(new Product(100, "Laptop", 9000.0));  
//		products.add(new Product(101, "Smart TV", 60000.00));  
//		products.add(new Product(102, "Mobile",  9000.00));  
//		return products;
		
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return orderepository.save(order);
	}

	@Override
	public Optional<Order> findOrdersById(int id) {
		// TODO Auto-generated method stub
		return orderepository.findById(id);
	}

	@Override
	public Order updateOrder(int id,Order o1) {
		// TODO Auto-generated method stub
		 Optional<Order> p= findOrdersById(id);
		 Order order= p.get();
		 order.setId(o1.getId());
		 order.setOrdName(o1.getOrdName());
		 order.setOrdPrice(o1.getOrdPrice());
		 return orderepository.save(o1);
	}

	@Override

	public Map<String, Boolean> deleteOrder(Integer orderId) throws ResourceNotFoundException {
		Order updateorder = orderepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Product is not avaialble:"+ orderId));
		orderepository.delete(updateorder);
		Map<String,Boolean> response  = new HashMap<>();
		response.put("Product has been Deleted", Boolean.TRUE);
		return response;
		}

}

