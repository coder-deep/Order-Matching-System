package com.oms.service;

import java.util.List;

import com.oms.beans.Buy_Order;
import com.oms.beans.Sell_Order;

public interface IBuy_OrderService {

	Buy_Order findById(int b_order_id);

	void addBuy_Order(Buy_Order order);

	List<Sell_Order> getQuantitiesMatchingOnBuyer(String id, double price);

	void updateQuantityBuyer(int id, int quantity);

	void updateStatusBuyer(int id);

}