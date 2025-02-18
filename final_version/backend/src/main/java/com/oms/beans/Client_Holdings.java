package com.oms.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity(name="client_holdings")
public class Client_Holdings {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int s_no;
	@JoinColumn(name="client_id",referencedColumnName = "client_id")
	String client_id;
	@JoinColumn(name="instrument_id",referencedColumnName = "instrument_id")
	String instrument_id;
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
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	@Override
	public String toString() {
		return "Client_Holdings [s_no=" + s_no + ", client_id=" + client_id + ", instrument_id=" + instrument_id
				+ "]";
	}
	public Client_Holdings(int s_no,String client_id, String instrument_id) {
		super();
		this.s_no=s_no;
		this.client_id = client_id;
		this.instrument_id = instrument_id;

	}
	public Client_Holdings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
