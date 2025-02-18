package com.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.ClientTotalSell;
import com.oms.repo.ClientTotalSellRepo;
@Service
public class ClientTotalSellService implements IClientTotalSellService {
@Autowired
ClientTotalSellRepo ictsr;
@Override
public List<ClientTotalSell> getTotalSell(String custodian_id) {
		return  ictsr.getclientsell(custodian_id);
	}

}
