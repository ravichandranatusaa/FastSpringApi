package com.fastspring.excercise.FastSpringAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.DiscountType;
import com.fastspring.excercise.FastSpringAPI.repository.IDiscountTypeRepo;

@Service
public class DiscountTypeService {

	
	@Autowired
	IDiscountTypeRepo discountTypeRepo;
	
	public DiscountType getDiscountType(Long id) {
		return discountTypeRepo.getOne(id);
	}
	
}
