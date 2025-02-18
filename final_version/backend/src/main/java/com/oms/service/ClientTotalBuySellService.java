package com.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.ClientTotalBuy;
import com.oms.repo.ClientTotalBuySellRepo;

@Service
public class ClientTotalBuySellService implements IClientTotalBuySellService {
	@Autowired
	ClientTotalBuySellRepo ctbsrep;
	@Override
	public List<ClientTotalBuy> getclientbuysellbycustodian(String custodian_id)
	{
		return ctbsrep.getclientbuysellbycustodian(custodian_id);
		
	}
}
