package com.fastspring.excercise.FastSpringAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERITEMS")
public class OrderItems {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "orderid")
	private Orders order;
	
	@ManyToOne
	@JoinColumn(name = "productid")
	private Product products;
	
	private boolean isvoided;
	private float discountval;
	private float discountperc;
	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public boolean isIsvoided() {
		return isvoided;
	}
	public void setIsvoided(boolean isvoided) {
		this.isvoided = isvoided;
	}
	public float getDiscountval() {
		return discountval;
	}
	public void setDiscountval(float discountval) {
		this.discountval = discountval;
	}
	public float getDiscountperc() {
		return discountperc;
	}
	public void setDiscountperc(float discountperc) {
		this.discountperc = discountperc;
	}
	
}
