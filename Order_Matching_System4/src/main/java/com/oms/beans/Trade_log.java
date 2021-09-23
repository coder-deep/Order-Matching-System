package com.oms.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name="trade_log")
public class Trade_log {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int t_id;
	@ManyToOne
	@Transient
	Buy_Order buy_order;
	@JoinColumn(name="b_order_id",referencedColumnName = "b_order_id")
	int b_order_id;
	@ManyToOne
	@Transient
	Sell_Order sell_order;
	@JoinColumn(name="s_order_id",referencedColumnName = "s_order_id")
	int s_order_id;
	int quantity;
	double price;
	LocalDateTime timestamp;
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getB_order_id() {
		return b_order_id;
	}
	public void setB_order_id(int b_order_id) {
		this.b_order_id = b_order_id;
	}
	public int getS_order_id() {
		return s_order_id;
	}
	public void setS_order_id(int s_order_id) {
		this.s_order_id = s_order_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Trade_log [t_id=" + t_id + ", b_order_id=" + b_order_id + ", s_order_id=" + s_order_id + ", quantity="
				+ quantity + ", timestamp=" + timestamp + "]";
	}
	public Trade_log(int t_id, int b_order_id, int s_order_id, int quantity, double price, LocalDateTime timestamp) {
		super();
		this.t_id = t_id;
		this.b_order_id = b_order_id;
		this.s_order_id = s_order_id;
		this.quantity = quantity;
		this.price=price;
		this.timestamp = timestamp;
	}
	public Trade_log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
