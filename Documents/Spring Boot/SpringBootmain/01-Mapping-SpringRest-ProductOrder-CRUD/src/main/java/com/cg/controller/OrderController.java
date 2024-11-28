package com.cg.controller;


import com.cg.entity.Order;
import com.cg.service.IOrderService;
import com.cg.service.ProductImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;
    
    @Autowired
    ProductImpl productservice;
    

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/getorderbyid/{id}")
    public Order getOrderById(@PathVariable int id) {
       return orderService.findOrderById(id);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order.getId(), order);

       
    }
    @DeleteMapping("/deletebyid/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/getallorders")
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();                       
    }
}
