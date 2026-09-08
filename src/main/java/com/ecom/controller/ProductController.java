package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.Product;
import com.ecom.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/product")
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		Product obj = service.saveProduct(product);
		if(obj != null) return new ResponseEntity<>("Product Added Successfully",HttpStatus.ACCEPTED);
		else return new ResponseEntity<>("Error in Product",HttpStatus.BAD_REQUEST);
			
		}
	
	@GetMapping("/products")
	public ResponseEntity<?> findAllProducts(){
		List<Product> list = service.findAllProducts();
		return new ResponseEntity<>(list,HttpStatus.FOUND);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		Product product = service.findById(id);
		if(product.getId() != 0) return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
		else return new ResponseEntity<>("Invalid Product ID",HttpStatus.NOT_FOUND);
			
		}
	
	@PutMapping("/product")
	public ResponseEntity<?> updateProduct(@RequestBody Product product){
		Product obj = service.saveProduct(product);
		if(obj != null) return new ResponseEntity<>("Product updated Successfully",HttpStatus.ACCEPTED);
		else return new ResponseEntity<>("Error in Updating Product",HttpStatus.BAD_REQUEST);
		}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id){
		Product obj = service.findById(id);
		if(obj.getId() != 0) {
			service.deleteById(id);
			return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
		}
		else return new ResponseEntity<>("Invalid Product Id",HttpStatus.BAD_REQUEST);
		
	}
		
}
