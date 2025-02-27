package com.cg.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.cg.entity.Product;

public interface IProductService {
	
	List<Product> findAllProducts() ;

	Optional<Product> findProductById(int id);
	
	public Product createProduct(Product p);

	public String deleteProduct(int id);

	List<Product> getProductByName(String name);

	String update(Product p, int id);

	int getCountpName(String pName);
	
	
}
