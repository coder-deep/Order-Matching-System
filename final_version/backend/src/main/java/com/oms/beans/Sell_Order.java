package com.oms.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.oms.enums.StatusENUM;

@Entity(name="sell_order")
public class Sell_Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer s_order_id;
	@ManyToOne
	@Transient
	Client client;
	@JoinColumn(name="seller_id",referencedColumnName = "client_id")
	String seller_id;
	@ManyToOne
	@Transient
	Custodian custodian;
	@JoinColumn(name="s_custodian_id",referencedColumnName = "custodian_id")
	String s_custodian_id;
	@ManyToOne
	@Transient
	Instrument instrument;
	@JoinColumn(name="instrument_id",referencedColumnName = "instrument_id")
	String instrument_id;
	double price;
	Integer quantity;
	@Enumerated(EnumType.STRING)
	StatusENUM status;
	LocalDateTime timestamp;
	
	public Integer getS_order_id() {
		return s_order_id;
	}
	public void setS_order_id(Integer s_order_id) {
		this.s_order_id = s_order_id;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getS_custodian_id() {
		return s_custodian_id;
	}
	public void setS_custodian_id(String s_custodian_id) {
		this.s_custodian_id = s_custodian_id;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
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
		return "Sell_Order [s_order_id=" + s_order_id + ", seller_id=" + seller_id + ", s_custodian_id="
				+ s_custodian_id + ", instrument_id=" + instrument_id + ", price=" + price + ", quantity=" + quantity
				+ ", status=" + status + ", timestamp=" + timestamp + "]";
	}
	public Sell_Order(Integer s_order_id, String seller_id, String s_custodian_id, String instrument_id, double price,
			Integer quantity, StatusENUM status, LocalDateTime timestamp) {
		super();
		this.s_order_id = s_order_id;
		this.seller_id = seller_id;
		this.s_custodian_id = s_custodian_id;
		this.instrument_id = instrument_id;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.timestamp = timestamp;
	}
	public Sell_Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
