package com.oms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oms.beans.Client;

public interface ClientRepo extends JpaRepository<Client, String>{
	@Query("select client_id from client WHERE custodian_id=?1")
	public List<String> getclientsbycustodian(@Param("custodian_id") String custodian_id);
}
