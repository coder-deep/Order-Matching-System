package com.oms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.beans.Auth;


public interface AuthRepo extends JpaRepository<Auth, String>{

}
