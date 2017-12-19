package com.fastspring.excercise.FastSpringAPI.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastspring.excercise.FastSpringAPI.domain.Coupon;

public interface ICouponRepo extends JpaRepository<Coupon, Serializable> {

}
