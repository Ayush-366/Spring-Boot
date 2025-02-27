package com.cg.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Product;
import com.cg.repository.ProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	ProductRepository productrepository;
	
	
	@Override
	public List<Product> findAllProducts() {
		
		return productrepository.findAll();
		
		
//		ArrayList<Product> products = new ArrayList<Product>();
//		products.add(new Product(100, "Laptop", 9000.0));  
//		products.add(new Product(101, "Smart TV", 60000.00));  
//		products.add(new Product(102, "Mobile",  9000.00));  
//		return products;
		
	}
	
	

	@Override
	public Optional<Product> findProductById(int id) {
		// TODO Auto-generated method stub
		return productrepository.findById(id);
	}



	@Override
	public Product createProduct(Product p) {
		// TODO Auto-generated method stub
		return productrepository.save(p);
	}



	@Override
	public String deleteProduct(int id) {
		// TODO Auto-generated method stub
		productrepository.deleteById(id);
		String i = Integer.toString(id);
		return i + " Product Has Been Deleted";
	}
	
	@Override
	public List<Product> getProductByName(String name)
	{
		return productrepository.findAllBypName(name);
	}
	
	@Override
	public String update( Product p, int id) {
	    if (productrepository.existsById(id)) {
	        Product product = new Product();
	        product.setId(id);
	        product.setpName(p.getpName());
	        product.setPrice(p.getPrice());
	        productrepository.save(product);
	        return "Product updated successfully";
	    } else {
	        return "Product ID not found";
	    }
	}
	
	@Override
	public int getCountpName(String pName)
	{
		return productrepository.findCountpName(pName);
	}


}
