package com.cg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product99")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "prodName")
	private String pName;
	
	@Column(name = "prodPrice")
	private double price;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getpName() {
		return pName;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public Product(int id, String pName, double price) {
		super();
		this.id = id;
		this.pName = pName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pName=" + pName + ", price=" + price + "]";
	}
	
	
}
