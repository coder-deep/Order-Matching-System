package com.oms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.Custodian;
import com.oms.repo.CustodianRepo;

@Service
public class CustodianService implements ICustodianService {
	@Autowired
	CustodianRepo curep;
	@Override
	public Custodian findById(String custodian_id)
	{
		Optional<Custodian> c = curep.findById(custodian_id);
		return c.get();
	}
}
