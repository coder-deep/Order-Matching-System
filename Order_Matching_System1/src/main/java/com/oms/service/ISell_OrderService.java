package com.oms.service;

import com.oms.beans.Sell_Order;

public interface ISell_OrderService {

	Sell_Order findById(int s_order_id);

	Sell_Order addSell_Order(Sell_Order order);

}