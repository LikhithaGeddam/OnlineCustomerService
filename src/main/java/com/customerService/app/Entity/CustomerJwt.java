package com.customerService.app.Entity;

public class CustomerJwt {
	private Customer customer;
	private String jwt;
	
	public CustomerJwt(Customer customer, String jwt) {
		super();
		this.customer = customer;
		this.jwt = jwt;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
