package com.oms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.beans.Instrument;

public interface InstrumentRepo extends JpaRepository<Instrument, String>{

}
