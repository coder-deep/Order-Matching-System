package com.oms.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientTotalSell {
	@Id
	String client_id;
	double tot_sell;
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public double getTot_sell() {
		return tot_sell;
	}
	public void setTot_sell(double tot_sell) {
		this.tot_sell = tot_sell;
	}
	@Override
	public String toString() {
		return "ClientTotalSell [client_id=" + client_id + ", tot_sell=" + tot_sell + "]";
	}
	public ClientTotalSell(String client_id, double tot_sell) {
		super();
		this.client_id = client_id;
		this.tot_sell = tot_sell;
	}
	public ClientTotalSell() {
		super();
		// TODO Auto-generated constructor stub
	}

}
