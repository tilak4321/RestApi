package com.dcl.ProductRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcl.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	

}
