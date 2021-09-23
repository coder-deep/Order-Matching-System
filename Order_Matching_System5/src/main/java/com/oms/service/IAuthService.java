package com.oms.service;

import java.util.List;

import com.oms.beans.Auth;

public interface IAuthService {

	Auth findById(String custodian_id);

	List<Auth> findAll();

}