package com.cg.dto;


import com.cg.entity.Product;

public class ProductDTO {
	
	private int id;
	private String pName;
	private double price;
	
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(int id, String pName, double price) {
		super();
		this.id = id;
		this.pName = pName;
		this.price = price;
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

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", pName=" + pName + ", price=" + price + "]";
	}
	
	//Convert from product entity to DTO Object
	public static ProductDTO fromEntity(Product product)
	{
		return new ProductDTO(product.getId(),product.getpName(),product.getPrice());
	}
	
	//From DTO to product Object
	public Product toEntity()
	{
		return new Product(this.id,this.pName,this.price);
	}

}
