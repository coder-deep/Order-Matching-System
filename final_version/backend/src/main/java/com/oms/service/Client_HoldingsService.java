package com.oms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.Client_Holdings;
import com.oms.beans.Instrument;
import com.oms.repo.Client_HoldingsRepo;

@Service
public class Client_HoldingsService implements IClient_HoldingsService {
	@Autowired
	Client_HoldingsRepo chrep;
	@Override
	public Client_Holdings findById(String client_id)
	{
		Optional<Client_Holdings> c = chrep.findById(client_id);
		return c.get();
	}
	@Override
	public Client_Holdings addHoldings(Client_Holdings holdings)
	{
		return chrep.save(holdings);
	}
//	@Override
//	public List<Instrument> getinstrumentsbyclient(String client_id)
//	{
//		return chrep.getinstrumentsbyclient(client_id);
//	}
}
