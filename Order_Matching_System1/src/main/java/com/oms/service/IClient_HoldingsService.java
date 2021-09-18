package com.oms.service;

import java.util.List;

import com.oms.beans.Client_Holdings;

public interface IClient_HoldingsService {

	Client_Holdings findById(String client_id);

	Client_Holdings addHoldings(Client_Holdings holdings);
	
	public List<String> getinstrumentsbyclient(String client_id);

}