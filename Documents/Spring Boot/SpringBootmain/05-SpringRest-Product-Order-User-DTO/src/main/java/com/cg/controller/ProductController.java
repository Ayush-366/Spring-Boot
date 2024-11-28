package com.cg.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.ProductDTO;
import com.cg.entity.Product;
import com.cg.service.IProductService;



@RequestMapping("/api")
@RestController
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return productService.findAllProducts()
                            .stream()
                            .map(ProductDTO::fromEntity)  // Convert to ProductDTO
                            .collect(Collectors.toList());
    }
	
	
//	@GetMapping("/products")
//	//@GetMapping(path = "/products", produces = {MediaType.APPLICATION_XML_VALUE})
//	public List<Product> getProduct()
//	{
//		return productService.findAllProducts();
//	}
 	
	@GetMapping("/hello")
	public String sayHello() 
	{
		return "Hello Applicaion";
	}

	@GetMapping(path = "/products/{id}")
    public List<ProductDTO> getByProductId(@PathVariable int id) {
        return productService.findProductById(id)
                            .stream()
                            .map(ProductDTO::fromEntity)  // Convert to ProductDTO
                            .collect(Collectors.toList());
    }
	
//	@GetMapping(path = "/products/{id}")
//	public Optional<Product>getByProductId(@PathVariable int id)
//	{
//		return productService.findProductById(id);
//	}
//	
	
	
	@GetMapping(path = "/products/myProduct")
	public Optional<Product> getByProductIdRequestparam(@RequestParam int id)
	{
		return productService.findProductById(id);
	}
	
	@PostMapping("/products")
	public ProductDTO createProduct(@Validated @RequestBody ProductDTO productDTO)
	{
		        Product product = productDTO.toEntity();  // Convert DTO to Entity
		        Product createdProduct = productService.createProduct(product);
		        return ProductDTO.fromEntity(createdProduct);  // Return as DTO
	}

	
//	@PostMapping("/products")
//	public Product createMyProduct(@RequestBody Product product)
//	{
//		return productService.createProduct(product);
//	}
	
	
	@DeleteMapping(path = "/products/{id}")
	public String deleteByProductId(@PathVariable int id)
	{
		return productService.deleteProduct(id);
	}
	
	@GetMapping(path = "/products/name/{name}")
	List<Product> findAllByPname(@PathVariable String name)
	{
		return productService.getProductByName(name);
	}
	
	@GetMapping (path = "/products/update/{id}")
	public String update(@PathVariable Product p,@PathVariable int id)
	{
		return productService.update(p, id);
	}
	
	@GetMapping (path = "/products/count/{pName}")
	public int getCount(@PathVariable String pName)
	{
		return productService.getCountpName(pName);
	}
	
	
}
