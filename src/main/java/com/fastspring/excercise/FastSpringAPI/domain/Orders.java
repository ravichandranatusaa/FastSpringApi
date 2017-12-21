package com.fastspring.excercise.FastSpringAPI.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="ORDERS")
public class Orders {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "storesessionid")
	private StoreSession storesession;
	
	
	@OneToOne
	@JoinColumn(name = "couponid")
	private Coupon coupons;
	
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<OrderItems> orderItems;
	
	
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public StoreSession getStoresession() {
		return storesession;
	}
	public void setStoresession(StoreSession storesession) {
		this.storesession = storesession;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Coupon getCoupons() {
		return coupons;
	}
	public void setCoupons(Coupon coupons) {
		this.coupons = coupons;
	}
	
	
}
