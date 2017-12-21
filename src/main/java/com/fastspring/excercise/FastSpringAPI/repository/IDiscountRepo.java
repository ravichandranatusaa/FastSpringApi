package com.fastspring.excercise.FastSpringAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastspring.excercise.FastSpringAPI.domain.Discount;
import com.fastspring.excercise.FastSpringAPI.domain.Product;
@Repository
public interface IDiscountRepo extends JpaRepository<Discount, Long> {

	public List<Discount> findByProduct(Product product);
}
