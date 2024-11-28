package com.cg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "orderName")
	private String ordName;
	
	@Column(name = "orderPrice")
	private double ordPrice;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getOrdName() {
		return ordName;
	}

	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}

	public double getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(double ordPrice) {
		this.ordPrice = ordPrice;
	}

	public Order(int id, String ordName, double ordPrice) {
		super();
		this.id = id;
		this.ordName = ordName;
		this.ordPrice = ordPrice;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", ordName=" + ordName + ", ordPrice=" + ordPrice + "]";
	}
	
	
	
	
}
