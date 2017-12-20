package com.fastspring.excercise.FastSpringAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.Product;
import com.fastspring.excercise.FastSpringAPI.repository.IProductRepo;

@Service
public class ProductService {


	@Autowired
	IProductRepo productRepo;
	
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
	public Product getProduct(Long id) {
		return productRepo.getOne(id);
	}
	
	public Product saveProduct(Product product) {
		if(product!=null) {
			product = productRepo.saveAndFlush(product);
		}
		return product;
	}
	
	public boolean deleteProduct(Product product) {
		if(product!=null) {
			productRepo.delete(product);
			return true;
		}
		return false;
	}

}
