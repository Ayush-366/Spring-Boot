package com.cg.dto;

import java.util.Date;
import java.util.List;

import com.cg.entity.Order;
import com.cg.entity.Product;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class OrderDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int orderId;
	
	@Column(name = "orderName")
	private String orderName;
	
	@Column(name = "orderDate")
	private Date orderDate;

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(int orderId, String orderName, Date orderDate) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", orderName=" + orderName + ", orderDate=" + orderDate + "]";
	}

	public static OrderDTO fromEntity(Order order) {
		// TODO Auto-generated method stub
		return new OrderDTO(order.getOrderId(),order.getOrderName(),order.getOrderDate());
	}
	
	public static ProductDTO fromEntity(Product product)
	{
		return new ProductDTO(product.getId(),product.getpName(),product.getPrice());
	}
	
	//From DTO to product Object
	public Order toEntity()
	{
		return new Order(this.orderId,this.orderName,this.orderDate);
	}
	
}
