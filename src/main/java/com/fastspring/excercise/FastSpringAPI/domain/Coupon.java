package com.fastspring.excercise.FastSpringAPI.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="COUPON")
public class Coupon {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String code;
	
	@OneToOne
	@JoinColumn(name = "discounttypeid")
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private DiscountType coupontype;
	
	public DiscountType getCoupontype() {
		return coupontype;
	}
	public void setCoupontype(DiscountType coupontype) {
		this.coupontype = coupontype;
	}
	private float value;
	private Date expirydate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
