package com.fastspring.excercise.FastSpringAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.Coupon;
import com.fastspring.excercise.FastSpringAPI.repository.ICouponRepo;

@Service
public class CouponService {

	
	@Autowired
	ICouponRepo couponRepo;
	
	public List<Coupon> getAllCoupons() {
		return couponRepo.findAll();
	}
	
	public Coupon saveCoupon(Coupon coupon) {
		if(coupon!=null) {
			coupon = couponRepo.saveAndFlush(coupon);
		}
		return coupon;
	}
	
	public boolean deleteCoupon(Coupon coupon) {
		if(coupon!=null) {
			couponRepo.delete(coupon);
			return true;
		}
		return false;
	}
	
}
