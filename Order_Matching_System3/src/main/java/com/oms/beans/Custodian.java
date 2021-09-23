package com.oms.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="custodian")
public class Custodian {
	@Id
	String custodian_id;
	String custodian_name;
	public String getCustodian_id() {
		return custodian_id;
	}
	public void setCustodian_id(String custodian_id) {
		this.custodian_id = custodian_id;
	}
	public String getCustodian_name() {
		return custodian_name;
	}
	public void setCustodian_name(String custodian_name) {
		this.custodian_name = custodian_name;
	}
	@Override
	public String toString() {
		return "Custodian [custodian_id=" + custodian_id + ", custodian_name=" + custodian_name + "]";
	}
	public Custodian(String custodian_id, String custodian_name) {
		super();
		this.custodian_id = custodian_id;
		this.custodian_name = custodian_name;
	}
	public Custodian() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
