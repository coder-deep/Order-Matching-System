package com.oms.controller;

import java.time.LocalDateTime;
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
	
	/*When Buy_order is sent
	b_quantity>s_quantity
	 Update s_quantity to 0
	 Update s_status to Inactive
	 Add one trade_log -- quantity = s_quantity
     Update b_quantity to b_quantity-s_quantity
	 b_quantity = b_quantity-s_quantity

	b_quantity==s_quantity
	 Update both status
	 Update both quantity
	 Add one trade_log
	 break
	 
	b_quantity<s_quantity
	 Update b_quantity to 0
	 Update b_status to Inactive
	 Add one trade_log -- quantity = b_quantity
	 Update s_quantity to s_quantity-b_quantity
	 */
	
	@PostMapping(value = "onbside")
	public String onBuyerSide(@RequestBody Buy_Order b) 
	{
		LocalDateTime now = LocalDateTime.now();
		b.setTimestamp(now);
		ibos.addBuy_Order(b);
		String s="Not Done";
		String i_id = b.getInstrument_id();
		double price = b.getPrice();
		int b_quantity=b.getQuantity();
		//int finalrem=0 ;
		List<Sell_Order> ls = isos.getQuantitiesMatchingOnSeller(i_id, price);
		System.out.println(ls.size());
		System.out.println(ls);
		for(int i=0;i<ls.size();i++) {
			int s_quantity=ls.get(i).getQuantity();
			int remaining=s_quantity-b_quantity;
			if(remaining<0) {
				System.out.println("In the If condition i.e b_quantity is more than s_quantity");
				isos.updateQuantitySeller(ls.get(i).getS_order_id(),0);
				isos.updateStatusSeller(ls.get(i).getS_order_id());
				s="Partially Done Buyer_Quantity Left";
				Trade_log t = new Trade_log();
				LocalDateTime now1 = LocalDateTime.now(); 
				t.setTimestamp(now1);
				t.setB_order_id(b.getB_order_id());
				t.setS_order_id(ls.get(i).getS_order_id());
				t.setPrice(b.getPrice());
				t.setQuantity(s_quantity);
				itls.save(t);
				ibos.updateQuantityBuyer(b.getB_order_id(), b_quantity-s_quantity);
				b_quantity = -remaining;
			}
			else if(remaining==0) {
				System.out.println("In the If condition i.e b_quantity is same as s_quantity");
				isos.updateQuantitySeller(ls.get(i).getS_order_id(),0);
				isos.updateStatusSeller(ls.get(i).getS_order_id());
				ibos.updateQuantityBuyer(b.getB_order_id(), 0);
				ibos.updateStatusBuyer(b.getB_order_id());
				s="Done";
				Trade_log t = new Trade_log();
				LocalDateTime now1 = LocalDateTime.now(); 
				t.setTimestamp(now1);
				t.setB_order_id(b.getB_order_id());
				t.setS_order_id(ls.get(i).getS_order_id());
				t.setPrice(b.getPrice());
				t.setQuantity(s_quantity);
				itls.save(t);
			}
			else if(remaining>0) {
				System.out.println("In the If condition i.e b_quantity is less than s_quantity");
				ibos.updateQuantityBuyer(b.getB_order_id(), 0);
				ibos.updateStatusBuyer(b.getB_order_id());
				s="Partially Done Seller_Quantity left";
				Trade_log t = new Trade_log();
				LocalDateTime now1 = LocalDateTime.now(); 
				t.setTimestamp(now1);
				t.setB_order_id(b.getB_order_id());
				t.setS_order_id(ls.get(i).getS_order_id());
				t.setPrice(b.getPrice());
				t.setQuantity(b_quantity);
				itls.save(t);
				isos.updateQuantitySeller(ls.get(i).getS_order_id(),remaining);
			}
		}
//		ibos.updateQuantityBuyer(b.getB_order_id(),finalrem);
//		if(finalrem==0)
//		{
//			ibos.updateStatusBuyer(b.getB_order_id());
//		}
		return s;
	}
}
