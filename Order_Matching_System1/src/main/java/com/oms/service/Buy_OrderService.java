package com.oms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.Buy_Order;
import com.oms.repo.Buyer_OrderRepo;

@Service
public class Buy_OrderService implements IBuy_OrderService {
	@Autowired
	Buyer_OrderRepo borep;
	@Override
	public Buy_Order findById(int b_order_id)
	{
		Optional<Buy_Order> c = borep.findById(b_order_id);
		return c.get();
	}
	@Override
	public Buy_Order addBuy_Order(Buy_Order order)
	{
		return borep.save(order);
	}
}
