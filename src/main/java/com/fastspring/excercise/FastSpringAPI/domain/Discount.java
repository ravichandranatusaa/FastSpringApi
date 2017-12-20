package com.fastspring.excercise.FastSpringAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DISCOUNT")
public class Discount {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "discounttypeid")
	private DiscountType discounttype;

	private int quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
