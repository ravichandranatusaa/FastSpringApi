package com.fastspring.excercise.FastSpringAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="PRODUCT")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String displayname;
	private float unitprice;
	private int defaultqty;
	private boolean isdefaultqtyedit;
	private boolean isremovable;
	
	@OneToOne
	@JoinColumn(name = "productformatid")
	private ProductFormat productformat;
	
	public ProductFormat getProductformat() {
		return productformat;
	}
	public void setProductformat(ProductFormat productformat) {
		this.productformat = productformat;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public int getDefaultqty() {
		return defaultqty;
	}
	public void setDefaultqty(int defaultqty) {
		this.defaultqty = defaultqty;
	}
	public boolean isIsdefaultqtyedit() {
		return isdefaultqtyedit;
	}
	public void setIsdefaultqtyedit(boolean isdefaultqtyedit) {
		this.isdefaultqtyedit = isdefaultqtyedit;
	}
	public boolean isIsremovable() {
		return isremovable;
	}
	public void setIsremovable(boolean isremovable) {
		this.isremovable = isremovable;
	}
	
	
	
}
