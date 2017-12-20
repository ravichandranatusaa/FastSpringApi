package com.fastspring.excercise.FastSpringAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.Orders;
import com.fastspring.excercise.FastSpringAPI.domain.StoreSession;
import com.fastspring.excercise.FastSpringAPI.repository.IOrdersRepo;
import com.fastspring.excercise.FastSpringAPI.repository.IStoreSessionRepo;

@Service
public class OrdersService {

	@Autowired
	IOrdersRepo ordersRepo;
	
	@Autowired
	IStoreSessionRepo storeSessionRepo;
	
	public List<Orders> getAllOrders() {
		return ordersRepo.findAll();
	}
	
	public Orders getOrder(Long id) {
		return ordersRepo.getOne(id);
	}
	
	public Orders saveOrder(Orders order) {
		if(order!=null) {
			order = ordersRepo.saveAndFlush(order);
		}
		return order;
	}
	
	public boolean deleteOrder(Orders order) {
		if(order!=null) {
			ordersRepo.delete(order);
			return true;
		}
		return false;
	}
	
	public Orders createOrder(Long storesessionid) {
		Orders order = new Orders();
		if(storesessionid!=null) {
			StoreSession storeSession = storeSessionRepo.getOne(storesessionid);
			order.setStoresession(storeSession);
			order = ordersRepo.saveAndFlush(order);
		}
		return order;
	}
	
	
}
