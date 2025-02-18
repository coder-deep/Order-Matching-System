package com.oms.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class ClientTotalBuy {
	@Id
	String client_id;
	String client_name;
	double tot_buy;
	
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public double getTot_buy() {
		return tot_buy;
	}
	public void setTot_buy(double tot_buy) {
		this.tot_buy = tot_buy;
	}
	
	@Override
	public String toString() {
		return "ClientTotalBuy [client_id=" + client_id + ", client_name=" + client_name + ", tot_buy=" + tot_buy + "]";
	}
	public ClientTotalBuy(String client_id, double tot_buy, String client_name) {
		super();
		this.client_id = client_id;
		this.tot_buy = tot_buy;
		this.client_name=client_name;
	}
	public ClientTotalBuy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
