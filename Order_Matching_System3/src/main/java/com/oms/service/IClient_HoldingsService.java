package com.oms.service;

import java.util.List;

import com.oms.beans.Client_Holdings;
import com.oms.beans.Instrument;

public interface IClient_HoldingsService {

	Client_Holdings findById(String client_id);

	Client_Holdings addHoldings(Client_Holdings holdings);
	
	public List<Instrument> getinstrumentsbyclient(String client_id);

}