package com.oms.service;

import java.util.List;

import com.oms.beans.Client;

public interface IClientService {

	Client findById(String client_id);

	List<Client> getclientsbycustodian(String custodian_id);

}