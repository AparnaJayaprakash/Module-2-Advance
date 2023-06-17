package com.ust.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.resource.Products;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public Products getProduct(long productId) {
		
		Optional<Products> optional = repository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
		
	}

	public List<Products> getProducts() {
		
		return repository.findAll();
		
		
	}
	
	public boolean add(Products product) {
		
		repository.save(product);
		return true;
	}
	
	public Products updateProduct(Products product) {
		Optional<Products> optional = repository.findById(product.getProductId());
		Products tempProduct = optional.get();
		
		tempProduct.setName(product.getName());
		tempProduct.setDescription(product.getDescription());
		tempProduct.setPrice(product.getPrice());
		tempProduct.setQty(product.getQty());
		
		return repository.save(tempProduct);
	}
	
	
	public void deleteProduct(long productId) {
		 repository.deleteById(productId);
	}
	
	

}
