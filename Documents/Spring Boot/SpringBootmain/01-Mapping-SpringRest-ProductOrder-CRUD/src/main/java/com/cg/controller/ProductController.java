package com.cg.controller;
 
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.exception.ResourceNotFound;
import com.cg.service.IOrderService;
import com.cg.service.IProductService;
 
@RequestMapping("/api")
@RestController
public class ProductController {
	@Autowired
	IProductService productService;
	
	@Autowired
	IOrderService orderService;
	
	//@GetMapping("/getProduct")
//	@GetMapping(path = "/products", produces = {MediaType.APPLICATION_XML_VALUE})
	//@GetMapping(path = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})

//	public List<Product> getProducts()
//	{
//		return productService.findAllProducts();
//	}
		 
	@GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAllProducts()
                            .stream()
                           // .map(ProductDTO::fromEntity)  // Convert to ProductDTO
                            .collect(Collectors.toList());
    }
	
//	@GetMapping(path = "/products/{id}")
//	public List<ProductDTO> getProductById(@PathVariable int id) {
//		return productService.findProductById(id)
//							.stream()
//							.map(ProductDTO::fromEntity)
//							.collect(Collectors.toList());
//	}
//	
	@GetMapping(path = "/products/myProduct")
	public Optional<Product> getProductByParamId(@RequestParam int id) {
		return productService.findProductById(id);
	}
	
	
	@GetMapping("/products/{id}")
	Optional<Product>findByProductIdFromDBWithException(@PathVariable int id) throws ResourceNotFound
	{	Optional<Product> product = productService.findProductById(id);
	
    	product.orElseThrow(() -> new ResourceNotFound("Product not found for this id :: " + id));
    	System.out.println(id);
    return product;	
	}
	
	@PostMapping("/prodpost")
	public Product createProduct(@RequestBody Product product) {
	    // Ensure the product has an associated order with a valid ID
	    if (product.getOrder() != null && product.getOrder().getId() > 0) {
	        // Set the provided order on the product
	        product.setOrder(product.getOrder());  // This links the Product to the Order
	    }

	    // Save and return the product (JPA will handle the foreign key relationship)
	    return productService.createProduct(product);  // Saving the product with its associated order
	}



	
//	@PostMapping("/prodpost")
//	public Product CreateProduct( @RequestBody Product product) {
//        return product = productService.createProduct(product);
//        }
	
	
	
	@DeleteMapping("/products/{id}")
	public void DeleteProduct(@PathVariable int id) {
		 productService.deleteProduct(id);
	}
	@PutMapping("/prodput")
	public Product UpdateProduct(@RequestBody Product p1) throws ResourceNotFound{
		int id = p1.getId();
		return productService.updateProduct(id,p1);
    	
	}
	
	@GetMapping(path="/products/getproductbyName/{name}")
	public List<Product> getProductByname(@PathVariable String name) {
		return productService.getProductByname(name);
	}
	@GetMapping(path="/products/count/{name}")
	public int getCountByProduct(@PathVariable String name){
		return productService.getCountByProductname(name);
	}
	
}