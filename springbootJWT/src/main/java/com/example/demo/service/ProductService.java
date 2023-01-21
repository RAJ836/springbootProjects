package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;


public interface ProductService {
	
	List<Product> findAllProducts();
	
	void removeProduct(Integer id);
	
	Product saveProduct(Product product);

	Product findProductById(Integer id);

}
