package com.oms.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="client_holdings")
public class Client_Holdings {
	@Id
	String client_id;
	
	String instrument_id;
	int quantity;
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(String instrument_id) {
		this.instrument_id = instrument_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Client_Holdings [client_id=" + client_id + ", instrument_id=" + instrument_id + ", quantity=" + quantity
				+ "]";
	}
	public Client_Holdings(String client_id, String instrument_id, int quantity) {
		super();
		this.client_id = client_id;
		this.instrument_id = instrument_id;
		this.quantity = quantity;
	}
	public Client_Holdings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
