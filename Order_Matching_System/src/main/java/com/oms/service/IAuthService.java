package com.oms.service;

import com.oms.beans.Auth;

public interface IAuthService {

	Auth findById(String custodian_id);

}