package com.oms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oms.beans.Client_Holdings;

public interface Client_HoldingsRepo extends JpaRepository<Client_Holdings, String>{
	@Query("select instrument_id from client_holdings WHERE client_id=?1")
	public List<String> getinstrumentsbyclient(@Param("client_id") String id);
}
