package com.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.beans.Buy_Order;
import com.oms.beans.Sell_Order;
import com.oms.beans.Trade_log;
import com.oms.service.IBuy_OrderService;
import com.oms.service.ISell_OrderService;
import com.oms.service.ITrade_logService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class OrderMatching {

	@Autowired
	IBuy_OrderService ibos;
	@Autowired
	ISell_OrderService isos;
	@Autowired
	ITrade_logService itls;
	
	@PostMapping(value = "onbside")
	public String onBuyerSide(@RequestBody Buy_Order b) 
	{
		ibos.addBuy_Order(b);
		String s="Not Done";
		Trade_log t = new Trade_log();
		String i_id = b.getInstrument_id();
		double price = b.getPrice();
		int b_quantity=b.getQuantity();
		int finalrem=0 ;
		List<Sell_Order> ls = ibos.getQuantitiesMatchingOnBuyer(i_id,price);
		System.out.println(ls.size());
		for(int i=0;i<ls.size();i++) {
			int s_quantity=ls.get(i).getQuantity();
			int remaining=s_quantity-b_quantity;
			if(remaining<=0) {
				System.out.println("In the If condition");
				isos.updateQuantitySeller(ls.get(i).getS_order_id(),0);
				isos.updateStatusSeller(ls.get(i).getS_order_id());
				remaining = -remaining;
				s="Done";
				t.setB_order_id(b.getB_order_id());
				t.setS_order_id(ls.get(i).getS_order_id());
				t.setPrice(b.getPrice());
				t.setQuantity(b_quantity);
				itls.save(t);
				if(remaining==0) {
					break;
				}
			}
			else {
				isos.updateQuantitySeller(ls.get(i).getS_order_id(),remaining);
			}
			finalrem=remaining;
		}
		ibos.updateQuantityBuyer(b.getB_order_id(),finalrem);
		if(finalrem==0)
		{
			ibos.updateStatusBuyer(b.getB_order_id());
		}
		return s;
	}
}
