package com.fastspring.excercise.FastSpringAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.OrderItems;
import com.fastspring.excercise.FastSpringAPI.repository.IOrderItemsRepo;
import com.fastspring.excercise.FastSpringAPI.repository.IStoreSessionRepo;

@Service
public class OrderItemsService {

	@Autowired
	IOrderItemsRepo orderItemsRepo;
	
	@Autowired
	IStoreSessionRepo storeSessionRepo;
	
	public List<OrderItems> getAllOrders() {
		return orderItemsRepo.findAll();
	}
	
	public OrderItems getOrderItem(Long id) {
		return orderItemsRepo.getOne(id);
	}
	
	public OrderItems saveOrderItem(OrderItems orderitem) {
		if(orderitem!=null) {
			orderitem = orderItemsRepo.saveAndFlush(orderitem);
		}
		return orderitem;
	}
	
	public boolean deleteOrderItem(OrderItems orderitem) {
		if(orderitem!=null) {
			orderItemsRepo.delete(orderitem);
			return true;
		}
		return false;
	}
	
}
