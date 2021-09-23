package com.oms.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="auth")
public class Auth {
	@Id
	String custodian_id;
	String password;
	public String getCustodian_id() {
		return custodian_id;
	}
	public String getPassword() {
		return password;
	}
	public Auth(String custodian_id, String password) {
		super();
		this.custodian_id = custodian_id;
		this.password = password;
	}
	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Auth [custodian_id=" + custodian_id + ", password=" + password + "]";
	}
	
}
