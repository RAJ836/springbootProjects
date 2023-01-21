package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo prodRepo;

	@Override
	public List<Product> findAllProducts() {
		
		return prodRepo.findAll();
	}

	@Override
	public void removeProduct(Integer id) {
		if(!prodRepo.existsById(id)) throw new ProductNotFoundException("Product not found with id : "+id);
		 prodRepo.deleteById(id);
		
	}

	@Override
	public Product saveProduct(Product product) {
		return prodRepo.save(product);
		
	}

	@Override
	public Product findProductById(Integer id) {
		Optional<Product> prod = prodRepo.findById(id);
		if(prod.isEmpty()) throw new ProductNotFoundException("Product not found with id : "+id);
		return prod.get();
	}

}
