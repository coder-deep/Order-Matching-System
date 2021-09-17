package com.oms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.Trade_log;
import com.oms.repo.Trade_logRepo;

@Service
public class Trade_logService implements ITrade_logService {
	@Autowired
	Trade_logRepo tlrep;
	@Override
	public Trade_log findById(int t_id)
	{
		Optional<Trade_log> c = tlrep.findById(t_id);
		return c.get();
	}
	@Override
	public Trade_log addTrade(Trade_log trade)
	{
		return tlrep.save(trade);
	}
}
