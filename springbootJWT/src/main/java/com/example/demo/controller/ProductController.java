package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(productService.findAllProducts());
	}
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Integer id){
		
		productService.removeProduct(id); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Integer id){
		try {
			Product product = productService.findProductById(id);
			return ResponseEntity.ok(product);
		} catch (ProductNotFoundException e) {
			
			throw e;
		}catch(Exception e) {
			return new ResponseEntity<String>("Exception Occured",HttpStatus.NOT_FOUND);
			
		}
		
	}

}
