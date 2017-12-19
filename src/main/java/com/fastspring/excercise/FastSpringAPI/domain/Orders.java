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

@Entity
@Table(name="ORDERS")
public class Orders {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "storesessionid")
	private StoreSession storesession;
	
	@OneToMany
	@JoinColumn(name = "couponid")
	private List<Coupon> coupons;
	
	
	public List<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}
	public StoreSession getStoresession() {
		return storesession;
	}
	public void setStoresession(StoreSession storesession) {
		this.storesession = storesession;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
