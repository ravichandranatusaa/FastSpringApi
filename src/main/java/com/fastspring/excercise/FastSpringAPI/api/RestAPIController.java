package com.fastspring.excercise.FastSpringAPI.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fastspring.excercise.FastSpringAPI.domain.Coupon;
import com.fastspring.excercise.FastSpringAPI.service.CouponService;

@RestController
@RequestMapping("/api")
public class RestAPIController {

	
	@Autowired
    CouponService couponService;
	
	@RequestMapping(value = "/coupon/", method = RequestMethod.GET)
    public ResponseEntity<List<Coupon>> listAllCoupons() {
		List<Coupon> coupons = couponService.getAllCoupons();
        if (coupons.isEmpty()) {
            return new ResponseEntity<List<Coupon>>(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Coupon>>(coupons, HttpStatus.OK);
    }
	
}
