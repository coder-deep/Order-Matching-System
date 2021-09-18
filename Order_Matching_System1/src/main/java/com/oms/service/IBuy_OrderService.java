package com.oms.service;

import com.oms.beans.Buy_Order;

public interface IBuy_OrderService {

	Buy_Order findById(int b_order_id);

	Buy_Order addBuy_Order(Buy_Order order);

}