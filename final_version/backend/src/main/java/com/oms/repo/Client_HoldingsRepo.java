package com.oms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oms.beans.Client_Holdings;
import com.oms.beans.Instrument;

public interface Client_HoldingsRepo extends JpaRepository<Client_Holdings, String>{
//	@Query(nativeQuery=true,value="select * from instrument where instrument_id in (select instrument_id from client_holdings WHERE client_id=?1)")
//	public List<Instrument> getinstrumentsbyclient(@Param("client_id") String id);
}
