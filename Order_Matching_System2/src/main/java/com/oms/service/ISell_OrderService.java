package com.oms.service;

import java.util.List;

import com.oms.beans.Buy_Order;
import com.oms.beans.Sell_Order;

public interface ISell_OrderService {

	Sell_Order findById(int s_order_id);

	Sell_Order addSell_Order(Sell_Order order);

	List<Buy_Order> getQuantitiesMatchingOnSeller(String id, double price);

	void updateStatusSeller(int id);

	void updateQuantitySeller(int id, int quantity);

}