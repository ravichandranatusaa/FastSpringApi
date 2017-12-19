package com.fastspring.excercise.FastSpringAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COUPONTYPE")
public class CouponType {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String typename;
	
	@OneToOne
    @JoinColumn(name="id", nullable=false)
    private Coupon coupon;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
