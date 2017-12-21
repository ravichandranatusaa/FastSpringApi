package com.fastspring.excercise.FastSpringAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.CouponType;
import com.fastspring.excercise.FastSpringAPI.repository.ICouponTypeRepo;

@Service
public class CouponTypeService {

	
	@Autowired
	ICouponTypeRepo couponTypeRepo;
	
	public CouponType getCouponType(Long id) {
		return couponTypeRepo.getOne(id);
	}
	
}
