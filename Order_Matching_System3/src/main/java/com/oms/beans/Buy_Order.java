package com.oms.beans;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

import com.oms.enums.StatusENUM;

@Entity(name="buy_order")
public class Buy_Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int b_order_id;
	@ManyToOne
	@Transient
	Client client;
	@JoinColumn(name="buyer_id",referencedColumnName = "client_id")
	String buyer_id;
	@ManyToOne
	@Transient
	Custodian custodian;
	@JoinColumn(name="b_custodian_id",referencedColumnName = "custodian_id")
	String b_custodian_id;
	@ManyToOne
	@Transient
	Instrument instrument;
	@JoinColumn(name="instrument_id",referencedColumnName = "instrument_id")
	String instrument_id;
	double price;
	int quantity;
	@Enumerated(EnumType.STRING)
	StatusENUM status;
	LocalDateTime timestamp;
	public int getB_order_id() {
		return b_order_id;
	}
	public void setB_order_id(int b_order_id) {
		this.b_order_id = b_order_id;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getB_custodian_id() {
		return b_custodian_id;
	}
	public void setB_custodian_id(String b_custodian_id) {
		this.b_custodian_id = b_custodian_id;
	}
	public String getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(String instrument_id) {
		this.instrument_id = instrument_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public StatusENUM getStatus() {
		return status;
	}
	public void setStatus(StatusENUM status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	@Override
	public String toString() {
		return "Buy_Order [b_order_id=" + b_order_id + ", buyer_id=" + buyer_id + ", b_custodian_id=" + b_custodian_id
				+ ", instrument_id=" + instrument_id + ", price=" + price + ", quantity=" + quantity + ", status="
				+ status + ", timestamp=" + timestamp + "]";
	}
	public Buy_Order(int b_order_id, String buyer_id, String b_custodian_id, String instrument_id, double price,
			int quantity, StatusENUM status, LocalDateTime timestamp) {
		super();
		this.b_order_id = b_order_id;
		this.buyer_id = buyer_id;
		this.b_custodian_id = b_custodian_id;
		this.instrument_id = instrument_id;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.timestamp = timestamp;
	}
	public Buy_Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
