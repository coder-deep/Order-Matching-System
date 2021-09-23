package com.oms.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.beans.Auth;
import com.oms.beans.Buy_Order;
import com.oms.beans.Client;
import com.oms.beans.Client_Holdings;
import com.oms.beans.Custodian;
import com.oms.beans.Instrument;
import com.oms.beans.Sell_Order;
import com.oms.beans.Trade_log;
import com.oms.service.IAuthService;
import com.oms.service.IBuy_OrderService;
import com.oms.service.IClientService;
import com.oms.service.IClient_HoldingsService;
import com.oms.service.ICustodianService;
import com.oms.service.IInstrumentService;
import com.oms.service.ISell_OrderService;
import com.oms.service.ITrade_logService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Controller {

	@Autowired
	IAuthService ias;
	@Autowired
	IClientService ics;
	@Autowired
	ICustodianService icus;
	@Autowired
	IInstrumentService iis;
	@Autowired
	IBuy_OrderService ibos;
	@Autowired
	ISell_OrderService isos;
	@Autowired
	ITrade_logService itls;
	@Autowired
	IClient_HoldingsService ichs;
	
	@GetMapping(value = "auth/{custodian_id}")
	public Auth getauth(@PathVariable("custodian_id") String custodian_id)
	{
		return ias.findById(custodian_id);
	}
	@GetMapping(value = "client/{client_id}")
	public Client getclient(@PathVariable("client_id") String client_id)
	{
		return ics.findById(client_id);
	}
	@GetMapping(value = "custodian/{custodian_id}")
	public Custodian getcustodian(@PathVariable("custodian_id") String custodian_id)
	{
		return icus.findById(custodian_id);
	}
	@GetMapping(value = "instrument/{instrument_id}")
	public Instrument getinstrument(@PathVariable("instrument_id") String instrument_id)
	{
		return iis.findById(instrument_id);
	}
	@GetMapping(value = "buy_order/{b_order_id}")
	public Buy_Order getbuy_order(@PathVariable("b_order_id") int b_order_id)
	{
		return ibos.findById(b_order_id);
	}
	@GetMapping(value = "sell_order/{s_order_id}")
	public Sell_Order getsell_order(@PathVariable("s_order_id") int s_order_id)
	{
		return isos.findById(s_order_id);
	}
	@PostMapping(value="buy_order")
	public ResponseEntity<Buy_Order> AddBuy_Order(@RequestBody Buy_Order order)
	{

		//LocalDateTime now = LocalDateTime.now();  
		//order.setTimestamp(now);
		//System.out.println(order);
		ibos.addBuy_Order(order);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	@PostMapping(value="sell_order")
	public ResponseEntity<Sell_Order> AddSell_Order(@RequestBody Sell_Order order)
	{

		//LocalDateTime now = LocalDateTime.now();  
		//order.setTimestamp(now);
		//System.out.println(order);
		isos.addSell_Order(order);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	@GetMapping(value = "trade_log/{t_id}")
	public Trade_log gettrade_log(@PathVariable("t_id") int t_id)
	{
		return itls.findById(t_id);
	}
	@PostMapping(value="trade_log")
	public ResponseEntity<Trade_log> Addtrade(@RequestBody Trade_log trade)
	{

		//LocalDateTime now = LocalDateTime.now();  
		//order.setTimestamp(now);
		//System.out.println(order);
		itls.addTrade(trade);
		return new ResponseEntity<>(trade,HttpStatus.OK);
	}
//	@GetMapping(value = "client_holdings/{client_id}")
//	public Client_Holdings getclient_holdings(@PathVariable("client_id") String client_id)
//	{
//		return ichs.findById(client_id);
//	}
	@GetMapping(value = "client_holdings/{client_id}")
	public List<String> getinstruments(@PathVariable("client_id") String client_id)
	{
		return ichs.getinstrumentsbyclient(client_id);
	}
	@PostMapping(value="client_holdings")
	public ResponseEntity<Client_Holdings> AddHoldings(@RequestBody Client_Holdings holdings)
	{
		ichs.addHoldings(holdings);
		return new ResponseEntity<>(holdings,HttpStatus.OK);
	}
	@GetMapping(value = "clientsbycustodian/{custodian_id}")
	public List<String> getclientsbycustodian(@PathVariable("custodian_id") String custodian_id)
	{
		return ics.getclientsbycustodian(custodian_id);
	}
	@GetMapping(value = "getBuyTotalByClient/{id}")
	public double getBuyTotalByClient(@PathVariable("id") String id)
	{
		return itls.getBuyTotalByClient(id);
	}
	@GetMapping(value = "getSellTotalByClient/{id}")
	public double getSellTotalByClient(@PathVariable("id") String id)
	{
		return itls.getSellTotalByClient(id);
	}
}
