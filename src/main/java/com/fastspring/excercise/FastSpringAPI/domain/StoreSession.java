package com.fastspring.excercise.FastSpringAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STORESESSION")
public class StoreSession {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "loginpersonid")
	private LoginPerson loginperson;
	
	
	@OneToOne
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isClosesession() {
		return closesession;
	}
	public void setClosesession(boolean closesession) {
		this.closesession = closesession;
	}
}
