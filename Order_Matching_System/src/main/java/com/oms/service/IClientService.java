package com.oms.service;

import com.oms.beans.Client;

public interface IClientService {

	Client findById(String client_id);

}