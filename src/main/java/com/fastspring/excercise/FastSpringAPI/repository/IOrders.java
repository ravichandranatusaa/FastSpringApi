package com.fastspring.excercise.FastSpringAPI.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastspring.excercise.FastSpringAPI.domain.Orders;

public interface IOrders extends JpaRepository<Orders, Serializable> {

}
