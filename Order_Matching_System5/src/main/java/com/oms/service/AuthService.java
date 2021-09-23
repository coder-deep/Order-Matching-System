package com.oms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.Auth;
import com.oms.repo.AuthRepo;

@Service
public class AuthService implements IAuthService {

	@Autowired
	AuthRepo arep;
	@Override
	public Auth findById(String custodian_id)
	{
		Optional<Auth> c = arep.findById(custodian_id);
		return c.get();
	}
	@Override
	public List<Auth> findAll(){
		return arep.findAll();
	}
}
