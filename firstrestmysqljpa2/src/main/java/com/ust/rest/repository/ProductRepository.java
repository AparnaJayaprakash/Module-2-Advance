package com.ust.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.rest.resource.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{
	
	
	

}
