package com.oms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.Buy_Order;
import com.oms.beans.Sell_Order;
import com.oms.repo.Seller_OrderRepo;

@Service
public class Sell_OrderService implements ISell_OrderService {
	@Autowired
	Seller_OrderRepo sorep;
	@Override
	public Sell_Order findById(int s_order_id)
	{
		Optional<Sell_Order> c = sorep.findById(s_order_id);
		return c.get();
	}
	@Override
	public Sell_Order addSell_Order(Sell_Order order)
	{
		return sorep.save(order);
	}
}
