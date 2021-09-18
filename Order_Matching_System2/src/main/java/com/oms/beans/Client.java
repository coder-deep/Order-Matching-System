package com.oms.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity(name="client")
public class Client {
	@Id
	String client_id;
	String client_name;
	@ManyToOne
	@Transient
	Custodian custodian;
	@JoinColumn(name="custodian_id",referencedColumnName = "custodian_id")
	String custodian_id;
	double total_transaction;
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getCustodian_id() {
		return custodian_id;
	}
	public void setCustodian_id(String custodian_id) {
		this.custodian_id = custodian_id;
	}
	public double getTotal_transaction() {
		return total_transaction;
	}
	public void setTotal_transaction(double total_transaction) {
		this.total_transaction = total_transaction;
	}
	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", client_name=" + client_name + ", custodian_id=" + custodian_id
				+ ", total_transaction=" + total_transaction + "]";
	}
	public Client(String client_id, String client_name, String custodian_id, double total_transaction) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
		this.custodian_id = custodian_id;
		this.total_transaction = total_transaction;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
