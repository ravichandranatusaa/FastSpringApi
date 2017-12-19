package com.fastspring.excercise.FastSpringAPI.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="COUPON")
public class Coupon {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	
	@OneToOne
	@JoinColumn(name = "coupontypeid")
	private CouponType coupontype;
	
	private float value;
	private Date expirydate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	
	
	
}
