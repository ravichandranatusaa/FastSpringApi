package com.fastspring.excercise.FastSpringAPI.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.Discount;
import com.fastspring.excercise.FastSpringAPI.repository.IDiscount;

@Service
public class DiscountService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private IDiscount discountRepo;
	
	public List<Discount> getAllCoupons() {
		return discountRepo.findAll();
	}
	
	public Discount saveCoupon(Discount discount) {
		if(discount!=null) {
			discount = discountRepo.saveAndFlush(discount);
		}
		return discount;
	}
	
	public boolean deleteCoupon(Discount discount) {
		if(discount!=null) {
			discountRepo.delete(discount);
			return true;
		}
		return false;
	}
	
}
