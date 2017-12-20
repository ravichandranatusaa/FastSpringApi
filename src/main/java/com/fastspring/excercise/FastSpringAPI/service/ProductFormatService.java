package com.fastspring.excercise.FastSpringAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.ProductFormat;
import com.fastspring.excercise.FastSpringAPI.repository.IProductFormatRepo;

@Service
public class ProductFormatService {
	@Autowired
	IProductFormatRepo productFormatRepo;

	public ProductFormat getProductFormat(Long id) {
		return productFormatRepo.getOne(id);
	}

}





