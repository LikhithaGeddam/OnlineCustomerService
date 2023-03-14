package com.customerService.app.Entity;

public class AdminJwt {
	private Admin admin;
	private String jwt;
	
	public AdminJwt(Admin admin, String jwt) {
		super();
		this.admin = admin;
		this.jwt = jwt;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
