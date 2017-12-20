package com.fastspring.excercise.FastSpringAPI.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name="STORESESSION")
public class StoreSession implements Persistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5078072603000690566L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loginpersonid")
	private LoginPerson loginperson;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "storeid")
	private Store store;
	
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public LoginPerson getLoginperson() {
		return loginperson;
	}
	public void setLoginperson(LoginPerson loginperson) {
		this.loginperson = loginperson;
	}
	private boolean closesession;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isClosesession() {
		return closesession;
	}
	public void setClosesession(boolean closesession) {
		this.closesession = closesession;
	}
	
	public boolean isNew() {
		if(id!=null) {
			return false;
		}
		return true;
	}
	
}
