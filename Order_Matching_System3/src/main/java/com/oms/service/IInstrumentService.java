package com.oms.service;

import java.util.List;

import com.oms.beans.Instrument;

public interface IInstrumentService {

	Instrument findById(String instrument_id);

	List<Instrument> findall();

}