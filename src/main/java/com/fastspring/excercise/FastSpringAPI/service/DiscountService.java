package com.fastspring.excercise.FastSpringAPI.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.Discount;
import com.fastspring.excercise.FastSpringAPI.domain.Product;
import com.fastspring.excercise.FastSpringAPI.repository.IDiscountRepo;

@Service
public class DiscountService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private IDiscountRepo discountRepo;
	
	public List<Discount> getAllDiscount() {
		return discountRepo.findAll();
	}
	
	public Discount saveDiscount(Discount discount) {
		if(discount!=null) {
			discount = discountRepo.saveAndFlush(discount);
		}
		return discount;
	}
	
	public boolean deleteDiscount(Discount discount) {
		if(discount!=null) {
			discountRepo.delete(discount);
			return true;
		}
		return false;
	}
	
	public List<Discount> getDiscount(Product product) {
		List<Discount> retlist = new ArrayList<Discount>();
		if(product!=null) {
			retlist = discountRepo.findByProduct(product);
		}
		return retlist;
	}
	
}
