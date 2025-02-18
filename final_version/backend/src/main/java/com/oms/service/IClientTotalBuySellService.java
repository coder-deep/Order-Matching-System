package com.oms.service;

import java.util.List;

import com.oms.beans.ClientTotalBuy;

public interface IClientTotalBuySellService {

	List<ClientTotalBuy> getclientbuysellbycustodian(String custodian_id);

}