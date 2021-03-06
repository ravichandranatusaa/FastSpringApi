package com.fastspring.excercise.FastSpringAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="ORDERITEMS")
public class OrderItems {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "orderid")
	private Orders order;
	
	@OneToOne
	@JoinColumn(name = "productid")
	private Product products;
	
	
	private int quantity;
	
	private boolean isvoided;
	private float discountval;
	private float discountperc;
	
	
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
