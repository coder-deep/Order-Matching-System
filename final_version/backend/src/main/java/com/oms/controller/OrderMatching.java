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
import com.oms.beans.Client;
import com.oms.beans.Client_Holdings;
import com.oms.beans.Sell_Order;
import com.oms.beans.Trade_log;
import com.oms.service.ClientService;
import com.oms.service.IBuy_OrderService;
import com.oms.service.IClientService;
import com.oms.service.IClient_HoldingsService;
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
	@Autowired
	IClientService ics;
	@Autowired
	IClient_HoldingsService ichs;
	
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
		Client c = ics.findById(b.getBuyer_id());
		if(b.getQuantity()*b.getPrice()>c.getTotal_transaction())
		{
			return "LOW FUNDS";
		}
		Client_Holdings ch=new Client_Holdings();
		ch.setClient_id(b.getBuyer_id());
		ch.setInstrument_id(b.getInstrument_id());
		
		LocalDateTime now = LocalDateTime.now();
		b.setTimestamp(now);
		ibos.addBuy_Order(b);
		String s="Processing....";
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
				s="Partially Done";
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
				ichs.addHoldings(ch);
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
				ichs.addHoldings(ch);
				break;
			}
			else if(remaining>0) {
				System.out.println("In the If condition i.e b_quantity is less than s_quantity");
				ibos.updateQuantityBuyer(b.getB_order_id(), 0);
				ibos.updateStatusBuyer(b.getB_order_id());
				s="Done";
				Trade_log t = new Trade_log();
				LocalDateTime now1 = LocalDateTime.now(); 
				t.setTimestamp(now1);
				t.setB_order_id(b.getB_order_id());
				t.setS_order_id(ls.get(i).getS_order_id());
				t.setPrice(b.getPrice());
				t.setQuantity(b_quantity);
				itls.save(t);
				isos.updateQuantitySeller(ls.get(i).getS_order_id(),remaining);
				b_quantity=0;
				ichs.addHoldings(ch);
				break;
			}
		}
//		ibos.updateQuantityBuyer(b.getB_order_id(),finalrem);
//		if(finalrem==0)
//		{
//			ibos.updateStatusBuyer(b.getB_order_id());
//		}
		return s;
	}
	
	@PostMapping(value = "onsside")
	public String onSellerSide(@RequestBody Sell_Order s) 
	{
		Client c = ics.findById(s.getSeller_id());
		if(s.getQuantity()*s.getPrice()>c.getTotal_transaction())
		{
			return "LOW FUNDS";
		}
		LocalDateTime now = LocalDateTime.now();
		s.setTimestamp(now);
		isos.addSell_Order(s);
		String m="Processing....";
		String i_id = s.getInstrument_id();
		double price = s.getPrice();
		int s_quantity=s.getQuantity();
		//int finalrem=0 ;
		List<Buy_Order> ls = ibos.getQuantitiesMatchingOnBuyer(i_id, price);
		System.out.println(ls.size());
		System.out.println(ls);
		for(int i=0;i<ls.size();i++) {
			int b_quantity=ls.get(i).getQuantity();
			int remaining=b_quantity-s_quantity;
			Client_Holdings ch=new Client_Holdings();
			ch.setClient_id(ls.get(i).getBuyer_id());
			ch.setInstrument_id(s.getInstrument_id());
			if(remaining<0) {
				System.out.println("In the If condition i.e s_quantity is more than b_quantity");
				ibos.updateQuantityBuyer(ls.get(i).getB_order_id(),0);
				ibos.updateStatusBuyer(ls.get(i).getB_order_id());
				m="Partially Done";
				Trade_log t = new Trade_log();
				LocalDateTime now1 = LocalDateTime.now(); 
				t.setTimestamp(now1);
				t.setS_order_id(s.getS_order_id());
				t.setB_order_id(ls.get(i).getB_order_id());
				t.setPrice(s.getPrice());
				t.setQuantity(b_quantity);
				itls.save(t);
				isos.updateQuantitySeller(s.getS_order_id(), s_quantity-b_quantity);
				s_quantity = -remaining;
				ichs.addHoldings(ch);
			}
			else if(remaining==0) {
				System.out.println("In the If condition i.e s_quantity is same as b_quantity");
				ibos.updateQuantityBuyer(ls.get(i).getB_order_id(),0);
				ibos.updateStatusBuyer(ls.get(i).getB_order_id());
				isos.updateQuantitySeller(s.getS_order_id(), 0);
				isos.updateStatusSeller(s.getS_order_id());
				m="Done";
				Trade_log t = new Trade_log();
				LocalDateTime now1 = LocalDateTime.now(); 
				t.setTimestamp(now1);
				t.setS_order_id(s.getS_order_id());
				t.setB_order_id(ls.get(i).getB_order_id());
				t.setPrice(s.getPrice());
				t.setQuantity(b_quantity);
				itls.save(t);
				ichs.addHoldings(ch);
				break;
			}
			else if(remaining>0) {
				System.out.println("In the If condition i.e s_quantity is less than b_quantity");
				isos.updateQuantitySeller(s.getS_order_id(), 0);
				isos.updateStatusSeller(s.getS_order_id());
				m="Done";
				Trade_log t = new Trade_log();
				LocalDateTime now1 = LocalDateTime.now(); 
				t.setTimestamp(now1);
				t.setS_order_id(s.getS_order_id());
				t.setB_order_id(ls.get(i).getB_order_id());
				t.setPrice(s.getPrice());
				t.setQuantity(s_quantity);
				itls.save(t);
				ibos.updateQuantityBuyer(ls.get(i).getB_order_id(),remaining);
				s_quantity=0;
				ichs.addHoldings(ch);
				break;
			}
		}
//		ibos.updateQuantityBuyer(b.getB_order_id(),finalrem);
//		if(finalrem==0)
//		{
//			ibos.updateStatusBuyer(b.getB_order_id());
//		}
		return m;
	}
}
