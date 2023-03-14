package com.customerService.app.Entity;

public class OperatorJwt {
	private Operator operator;
	private String jwt;
	
	public OperatorJwt(Operator operator, String jwt) {
		super();
		this.operator = operator;
		this.jwt = jwt;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
