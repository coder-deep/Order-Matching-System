package com.oms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.Buy_Order;
import com.oms.beans.Sell_Order;
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
	public void addBuy_Order(Buy_Order order)
	{
		 borep.save(order);
	}
	@Override
	public List<Sell_Order> getQuantitiesMatchingOnBuyer(String id, double price)
	{
		return borep.getQuantitiesMatchingOnBuyer(id, price);
		
	}
	@Override
	public void updateQuantityBuyer(int id, int quantity)
	{
		 borep.updateQuantityBuyer(id, quantity);
	}
	@Override
	public void updateStatusBuyer(int id)
	{
		borep.updateStatusBuyer(id);
	}
}
