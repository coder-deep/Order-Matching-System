package com.oms.service;

import java.util.List;

import com.oms.beans.ClientTotalSell;

public interface IClientTotalSellService {

	List<ClientTotalSell> getTotalSell(String custodian_id);

}