package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new Product());
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
}
