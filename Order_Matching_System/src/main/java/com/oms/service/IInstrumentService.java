package com.oms.service;

import com.oms.beans.Instrument;

public interface IInstrumentService {

	Instrument findById(String instrument_id);

}