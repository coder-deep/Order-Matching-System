package com.oms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.Client;
import com.oms.repo.ClientRepo;

@Service
public class ClientService implements IClientService {
	@Autowired
	ClientRepo crep;
	@Override
	public Client findById(String client_id)
	{
		Optional<Client> c = crep.findById(client_id);
		return c.get();
	}
}
