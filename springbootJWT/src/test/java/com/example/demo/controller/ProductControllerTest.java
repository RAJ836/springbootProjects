package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@SpringBootTest
class ProductControllerTest {

	@Mock
	private ProductService prodService;
	
	@InjectMocks
	private ProductController prodController;
	
	@BeforeAll
	void beforeEach() {
		when(prodService.findProductById(1)).thenReturn(new Product(1,"lappy",100.0,"dell lappy"));
		when(prodService.findAllProducts()).thenReturn(
				List.of(
				new Product(1,"lappy",100.0,"dell lappy"),
				new Product(2, "sneakers", 150.0, "NIke brand"),
				new Product(3,"pen",10.0,"parker pens")
				));
	}
	
	@Test
	void testProductById() {
		Product product = (Product) prodController.getProduct(1).getBody();
		
		assertEquals("lappy", product.getProductName());
	}
	
	@Test
	void testFindAllProducts(){
		List<Product> products = prodController.getAllProducts().getBody();
		assertAll(
				() -> assertEquals(3, products.size()),
				() -> assertEquals("lappy", products.get(0).getProductName()),
				() -> assertEquals("parker pens", products.get(2).getProdDesc())
				);
		
	}
	

}
